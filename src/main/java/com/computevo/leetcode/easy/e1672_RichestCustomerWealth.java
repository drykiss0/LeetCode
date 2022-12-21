package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/richest-customer-wealth/
 */
public class e1672_RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
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
