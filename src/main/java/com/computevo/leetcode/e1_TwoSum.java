package com.computevo.leetcode;

import java.util.HashMap;
import java.util.Map;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/two-sum/?envType=study-plan&id=level-1">link</a>
 */
public class e1_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> idxMap = new HashMap<>();
        Integer oppositeNumIdx;
        for (int i = 0; i < nums.length; i++) {
            oppositeNumIdx = idxMap.get(target - nums[i]);
            if (oppositeNumIdx != null) {
                return new int[]{ oppositeNumIdx, i };
            }
            idxMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] nums3 = {3,3};
        int target3 = 6;

        printInput("nums", "target", new Object[][] {
                { nums1, target1 }, { nums2, target2 }, { nums3, target3 }
        });
        printOutput(
                "twoSum1", new e1_TwoSum().twoSum(nums1, target1),
                "twoSum2", new e1_TwoSum().twoSum(nums2, target2),
                "twoSum3", new e1_TwoSum().twoSum(nums3, target3)
        );
    }
}
