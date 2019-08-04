package com.snow87;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BobbertSort {

    private class Node {
        Node[] children;
        List<Object> values;
        int current = 0;

        Node() {
            children = new Node[unknownCharRank + 1];
        }

        List<Object> takeValues() {
            List<Object> temp = values;
            values = null;
            return temp;
        }

        void addValue(Object value) {
            if (values == null) values = new ArrayList<>();
            values.add(value);
        }

        boolean hasNext() {
            int i = current;
            while (i < children.length && children[i] == null) {
                i++;
            }
            current = i;
            return i < children.length;
        }

        Node next() {
            return hasNext() ? children[current++] : null;
        }
    }

    private Map<Character, Integer> characterRank;
    private int unknownCharRank;

    public BobbertSort(String rankString) {
        char[] chars = rankString.toCharArray();
        characterRank = IntStream.range(0, chars.length).boxed()
                .collect(Collectors.toMap(i -> chars[i], i -> i));
        unknownCharRank = rankString.length();
    }

    private List<Object> flatten(Node node, int numberOfValues) {
        Deque<Node> stack = new LinkedList<>();
        stack.push(node);
        List<Object> result = new ArrayList<>(numberOfValues);

        Node current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current.values != null) result.addAll(current.takeValues());
            if(current.hasNext()) {
                stack.push(current);
                stack.push(current.next());
            }
        }
        return result;
    }

    public List<String> sort(List<String> strings) {
        Node buckets = new Node();

        for (String s : strings) {
            Node current = buckets;
            for (int i = 0; i < s.length(); i++) {
                int r = Optional.ofNullable(characterRank.get(s.charAt(i))).orElse(unknownCharRank);
                if (current.children[r] == null) {
                    current.children[r] = new Node();
                    current = current.children[r];
                } else {
                    current = current.children[r];
                }
            }
            current.addValue(s);
        }
        return (List) flatten(buckets, strings.size());
    }
}
