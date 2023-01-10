package com.computevo.leetcode.round1;


import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class e88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int mi = m - 1;
        int ni = n - 1;
        int ii = nums1.length - 1;
        while (ii >= 0 && ni >= 0) {

            if (mi >= 0 && nums1[mi] > nums2[ni]) {
                nums1[ii--] = nums1[mi--];
            } else {
                nums1[ii--] = nums2[ni--];
            }
        }
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        System.out.printf(
                "merge(%s, %s, %s, %s) = %n", Arrays.toString(nums1), m, Arrays.toString(nums2), n);
        new e88_MergeSortedArray().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
