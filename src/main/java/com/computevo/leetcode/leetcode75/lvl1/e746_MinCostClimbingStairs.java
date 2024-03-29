package com.computevo.leetcode.leetcode75.lvl1;

import com.computevo.leetcode.helper.Utils;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/?envType=study-plan&id=level-1">link</a>
 */
public class e746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        int prevprev = cost[0];
        int prev = cost[1];
        int temp;
        for (int i = 2; i < cost.length; i++) {
            temp = prev;
            prev = Math.min(prevprev, prev) + cost[i];
            prevprev = Math.min(temp, prevprev + cost[i-1]);
        }
        return Math.min(prevprev, prev);
    }

    /**
     * Official Solution
     */
    @SuppressWarnings("unused")
    public int minCostClimbingStairs_Official(int[] cost) {
        int downOne = 0;
        int downTwo = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int temp = downOne;
            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
            downTwo = temp;
        }

        return downOne;
    }

    public static void main(String[] args) {

        int[] cost1 = {10,15,20};
        int[] cost2 = {1,100,1,1,1,100,1,1,100,1};

        Utils.printInput("cost1", cost1, "cost2", cost2);
        Utils.printOutput(
                "minCostClimbingStairs(cost1)", new e746_MinCostClimbingStairs().minCostClimbingStairs(cost1),
                "minCostClimbingStairs(cost2)", new e746_MinCostClimbingStairs().minCostClimbingStairs(cost2)
        );
    }
}
