package com.computevo.leetcode.round1;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class e121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int max = 0;
        int currentMax = 0;
        for (int i = 1; i < prices.length; i++) {
            currentMax = Math.max(currentMax + prices[i] - prices[i - 1], prices[i] - prices[i - 1]);
            max = Math.max(max, currentMax);
        }

        return max;
    }


    public static void main(String[] args) {

        /*
         int[] prices = {7,1,5,3,6,4};
         int[] prices = {7,6,4,3,1};
        */
        int[] prices = {7, 2, 4, 1};
        System.out.println("maxProfit(" + Arrays.toString(prices) + ") = "
                + new e121_BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}
