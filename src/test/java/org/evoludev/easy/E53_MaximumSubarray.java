package org.evoludev.easy;

import org.junit.Test;

import java.util.Arrays;

public class E53_MaximumSubarray {

    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(max, currentMax);
        }

        return max;
    }


    @Test
    public void test() {

        //int[] num = {-2,1,-3,4,-1,2,1,-5,4};// output: 6
        int[] num = {0, 6, 5, -5, -5, 20};// output: 21
        System.out.println("maxSubArray(" + Arrays.toString(num) + ") = " + maxSubArray(num));
    }
}