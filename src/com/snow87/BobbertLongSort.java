package com.snow87;

public class BobbertLongSort extends BobbertSort<Long> {

    //+1 to account for the sign
    private int maxDigits = String.valueOf(Long.MAX_VALUE).length()+1;
    public BobbertLongSort() {
        super(9);
    }

    @Override
    protected void placeValue(TreeNode<Long> root, Long value) {
        boolean neg = value < 0;
        root = neg ? root.child(0) : root.child(1);
        int[] digitRanks = new int[maxDigits];
        long temp = Math.abs(value);
        int lastDigit = 0;
        while(temp > 0) {
            int r = (int) (temp % 10);
            //invert the digit if it's negative to represent a higher rank
            if(neg) {
                r = 9 - r;
            }
            digitRanks[lastDigit++] = r;
            temp = temp /10;
        }

        for (int i = digitRanks.length-1; i >= 0; i--) {
            root = root.child(digitRanks[i]);
        }
        root.addValue(value);
    }
}
