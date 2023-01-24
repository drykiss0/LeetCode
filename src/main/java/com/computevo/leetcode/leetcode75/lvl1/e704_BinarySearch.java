package com.computevo.leetcode.leetcode75.lvl1;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/binary-search/?envType=study-plan&id=level-1">link</a>
 */
public class e704_BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;
        while (right >= left) {
            pivot = (right + left) / 2;
            if (nums[pivot] > target)
                right = pivot - 1;
            else if (nums[pivot] < target)
                left = pivot + 1;
            else return pivot;
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        printInput("num", nums, "target", target);
        printOutput(new e704_BinarySearch().search(nums, target));
    }
}
