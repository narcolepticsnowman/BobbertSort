package com.snow87;

import java.util.List;

public abstract class BobbertSort<T> {
    protected int maxRank;
    private TreeNode<T> root;

    public BobbertSort(int maxRank){
        this.maxRank = maxRank;
        this.root = new TreeNode<>(maxRank + 1);
    }

    public List<T> sort(List<T> longs) {
        longs.forEach(l->placeValue(root, l));

        return root.flatten(longs.size());
    }

    protected abstract void placeValue(TreeNode<T> root, T value);
}
