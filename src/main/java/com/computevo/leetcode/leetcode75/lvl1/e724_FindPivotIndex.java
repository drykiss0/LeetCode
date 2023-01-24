package com.computevo.leetcode.leetcode75.lvl1;

import com.computevo.leetcode.helper.Utils;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1">e724_FindPivotIndex</a>
 */
public class e724_FindPivotIndex {

    public int pivotIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,1,0};

        int result = new e724_FindPivotIndex().pivotIndex(nums);

        Utils.printSolution(nums, result);
    }
}
