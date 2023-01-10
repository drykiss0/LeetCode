package com.computevo.leetcode;

import static com.computevo.leetcode.helper.Utils.printSolution;

/**
 * <a href="https://leetcode.com/problems/richest-customer-wealth/">link</a>
 */
public class e1672_RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            if (sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] accounts = {{1,2,3},{3,2,1}};

        int result = new e1672_RichestCustomerWealth().maximumWealth(accounts);

        printSolution(accounts, result);
    }
}
