package com.snow87;

public class BobbertAsciiStringSort extends BobbertSort<String> {

    public BobbertAsciiStringSort() {
        //printable char range is from 32-126
        super(95);
    }

    @Override
    protected void placeValue(TreeNode<String> root, String value) {
        for (int i = 0; i < value.length(); i++) {
            int r = value.charAt(i) - 32;
            root = root.child(r);
        }
        root.addValue(value);
    }
}
