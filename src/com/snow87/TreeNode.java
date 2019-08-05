package com.snow87;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode<T> {
    private TreeNode<T>[] children;
    private List<T> values;
    private int current = 0;

    TreeNode(int maxChildren) {
        children = new TreeNode[maxChildren];
    }

    boolean hasChild(int i) {
        return children[i] != null;
    }

    TreeNode<T> child(int i){
        if (!this.hasChild(i)) {
            this.initChild(i);
        }
        return children[i];
    }

    void initChild(int i) {
        children[i] = new TreeNode(children.length);
    }

    boolean hasValues(){
        return values != null;
    }

    List<T> takeValues() {
        List<T> temp = values;
        values = null;
        return temp;
    }

    void addValue(T value) {
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

    TreeNode<T> next() {
        return hasNext() ? children[current++] : null;
    }

    List<T> flatten(int numberOfValues) {
        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.push(this);
        List<T> result = new ArrayList<>(numberOfValues);

        TreeNode<T> current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current.hasValues()) result.addAll(current.takeValues());
            if(current.hasNext()) {
                stack.push(current);
                stack.push(current.next());
            }
        }
        return result;
    }
}
