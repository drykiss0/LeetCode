package org.evoludev.easy;

import org.junit.Test;

import java.util.Arrays;

public class E26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int insertPos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        return insertPos;
    }

    @Test
    public void test() {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println("Input nums = " + Arrays.toString(nums));
        System.out.println("Input size = " + nums.length);
        System.out.println("---------");
        System.out.println("Solved size = " + removeDuplicates(nums));
        System.out.println("Solved nums = " + Arrays.toString(nums));
    }
}