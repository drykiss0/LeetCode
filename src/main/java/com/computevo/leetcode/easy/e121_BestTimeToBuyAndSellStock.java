package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan&id=level-1
 */
public class e121_BestTimeToBuyAndSellStock {

    private int maxProfit(int[] prices, int left, int right) {
        if (left >= right) return 0;
        int profit = prices[right] - prices[left];
        return Math.max(profit, Math.max(maxProfit(prices, left + 1, right), maxProfit(prices, left, right - 1)));
    }

    public int maxProfit(int[] prices) {
        return Math.max(0, maxProfit(prices, 0, prices.length - 1));
    }

    public static void main(String[] args) {

        int[] prices = {1,2,3,4};

        int result = new e121_BestTimeToBuyAndSellStock().maxProfit(prices);

        printSolution(prices, result);
    }
}
