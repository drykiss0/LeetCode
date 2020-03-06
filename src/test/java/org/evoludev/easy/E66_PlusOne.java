package org.evoludev.easy;

import org.junit.Test;

import java.util.Arrays;

public class E66_PlusOne {

    public int[] plusOne(int[] digits) {

        int plusOne = digits[digits.length - 1] + 1;
        digits[digits.length - 1] = plusOne % 10;
        int carry = plusOne / 10;

        for (int i = digits.length - 2; carry > 0 && i >= 0; i--) {
            int plusCarry = digits[i] + carry;
            digits[i] = plusCarry % 10;
            carry = plusCarry / 10;
        }
        if (carry > 0) {
            int[] biggerArr = new int[digits.length + 1];
            System.arraycopy(digits, 0, biggerArr, 1, digits.length);
            biggerArr[0] = carry;
            return biggerArr;
        }

        return digits;
    }


    @Test
    public void test() {

        int[] num = {0};// output: {1}
        System.out.println("plusOne(" + Arrays.toString(num) + ") = " + Arrays.toString(plusOne(num)));
    }
}