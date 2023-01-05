package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan&id=level-1">link</a>
 */
public class e121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int currentProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (currentProfit < price - min) {
                currentProfit = price - min;
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
