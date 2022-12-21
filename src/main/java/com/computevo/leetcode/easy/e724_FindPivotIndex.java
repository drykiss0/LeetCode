package com.computevo.leetcode.easy;

import java.util.Arrays;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1
 */
public class e724_FindPivotIndex {

    public int pivotIndex(int[] nums) {

        int[] runningSum = Arrays.copyOf(nums, nums.length);
        for(int i = 1; i < runningSum.length; i++) {
            runningSum[i] += runningSum[i-1];
        }
        int[] runningTailSum = Arrays.copyOf(nums, nums.length);
        for(int i = runningTailSum.length - 1; i > 0; i--) {
            runningTailSum[i-1] += runningTailSum[i];
        }

        for (int i = 0; i < runningSum.length; i++) {
            if (runningSum[i] == runningTailSum[i])
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {2,1,-1};

        int result = new e724_FindPivotIndex().pivotIndex(nums);

        printSolution(nums, result);
    }
}
