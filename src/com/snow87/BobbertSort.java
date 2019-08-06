package com.snow87;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BobbertSort {

    private class DepthList {
        List<String> list;
        int depth;

        DepthList(List<String> values, int depth) {
            this.list = values;
            this.depth = depth;
        }
    }

    List<String> sort(List<String> strings) {
        if (strings == null || strings.isEmpty()) return strings;
        List<String> results = new LinkedList<>();
        Deque<DepthList> stack = new LinkedList<>();
        stack.push(new DepthList(strings, 0));
        long totalIterations = 0;
        DepthList current;
        while (!stack.isEmpty()) {
            List<String>[] buckets = null;
            current = stack.pop();
            if (current.list.size() == 1) {
                results.add(current.list.get(0));
            } else {
                for(String s : current.list) {
                    totalIterations++;
                    if(current.depth == 0 && s== null){
                        results.add(s);
                    } else if (s != null && s.length() == current.depth) {
                        results.add(s);
                    } else if (s != null && s.length() > current.depth) {
                        int currentChar = s.charAt(current.depth) - 32;
                        if(buckets == null) buckets = new List[95];
                        if(buckets[currentChar] == null) buckets[currentChar] = new LinkedList<>();
                        buckets[currentChar].add(s);
                    }
                }
                for(int i=94; i>=0; i--){
                    if(buckets != null && buckets[i] != null) stack.push(new DepthList(buckets[i], current.depth + 1));
                }
            }

        }

        System.out.println("Total Iterations: " + totalIterations);
        return results;

    }
}
