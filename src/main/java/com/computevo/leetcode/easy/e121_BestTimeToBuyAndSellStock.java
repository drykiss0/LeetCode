package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan&id=level-1
 */
public class e121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int currentProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (currentProfit < prices[i] - min) {
                currentProfit = prices[i] - min;
            }
        }
        return currentProfit;
    }

    public static void main(String[] args) {

        int[] prices = {1,2,3,4};

        int result = new e121_BestTimeToBuyAndSellStock().maxProfit(prices);

        printSolution(prices, result);
    }
}
