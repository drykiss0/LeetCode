package org.evoludev.easy;

import org.junit.Test;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class E101_SymmetricTree_Recursive {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + (left != null ? " L" + left: "") + (right != null ? " R" + right: "");
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == right || left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                isSymmetric(left.left, right.right)
                &&
                isSymmetric(left.right, right.left);
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(String.format("isSymmetric(%s) = %s", root, isSymmetric(root)));
    }
}