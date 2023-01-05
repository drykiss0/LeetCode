package com.computevo.leetcode.easy;

import java.util.Arrays;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * <a href="https://leetcode.com/problems/running-sum-of-1d-array/">link</a>
 */
public class e1480_RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {

        int[] runningSum = Arrays.copyOf(nums, nums.length);
        for(int i = 1; i < runningSum.length; i++) {
            runningSum[i] += runningSum[i-1];
        }
        return runningSum;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        int[] result = new e1480_RunningSumOf1dArray().runningSum(nums);

        printSolution(nums, result);
    }
}
