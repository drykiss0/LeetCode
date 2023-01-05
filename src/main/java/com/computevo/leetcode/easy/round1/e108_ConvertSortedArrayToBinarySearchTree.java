package com.computevo.leetcode.easy.round1;

import com.computevo.leetcode.easy.helper.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class e108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        if (nums == null || nums.length == 0 || start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(nums, start, middle - 1);
        node.right = sortedArrayToBST(nums, middle + 1, end);
        return node;
    }


    public String toBfsString(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        e108_ConvertSortedArrayToBinarySearchTree obj = new e108_ConvertSortedArrayToBinarySearchTree();
        //int[] arr = {-10,-3,0,5,9};
        int[] arr = {0, 1, 2, 3, 4, 5};

        printSolution(
                Arrays.toString(arr),
                obj.toBfsString(obj.sortedArrayToBST(arr))
        );
    }

}
