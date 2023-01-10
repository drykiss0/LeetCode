package com.computevo.leetcode.round1;


import static com.computevo.leetcode.helper.Utils.printSolution;

public class e26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int insertPos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        return insertPos;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = new e26_RemoveDuplicatesFromSortedArray().removeDuplicates(nums);

        printSolution(nums, result);
    }
}
