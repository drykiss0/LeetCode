package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printInput;
import static com.computevo.leetcode.easy.helper.Utils.printOutput;

/**
 * https://leetcode.com/problems/binary-search/?envType=study-plan&id=level-1
 */
public class e704_BinarySearch {

    public int search(int[] nums, int target) {
        return 0;
    }


    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        printInput("num", nums, "target", target);
        printOutput(new e704_BinarySearch().search(nums, target));
    }
}
