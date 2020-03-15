package org.evoludev.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class E101_SymmetricTree_Iterative {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public int[] toBfsArray(TreeNode root) {
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
        return result.stream().mapToInt(v -> v).toArray();
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {

            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
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

        System.out.println(String.format("isSymmetric(%s) = %s", Arrays.toString(toBfsArray(root)), isSymmetric(root)));
    }

    /**
     * Experimental: can it help printing the tree?
     */
    private class TreeNodeWithLevel {
        public TreeNode node;
        public int level;

        public Integer val() {
            return node != null ? node.val : null;
        }

        public TreeNode left() {
            return node != null ? node.left : null;
        }

        public TreeNode right() {
            return node != null ? node.right : null;
        }

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}