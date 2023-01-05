package com.computevo.leetcode.easy;

import com.computevo.leetcode.easy.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.computevo.leetcode.easy.helper.Utils.printInput;
import static com.computevo.leetcode.easy.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=study-plan&id=level-1">link</a>
 */
public class m102_BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public record NodeInfo(int level, TreeNode node) {
    }

    public List<List<Integer>> levelOrderMine(TreeNode root) {

        if (root == null)
            return List.of();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<NodeInfo> stack = new LinkedList<>();
        stack.push(new NodeInfo(0, root));

        while (!stack.isEmpty()) {
            NodeInfo nodeInfo = stack.pop();
            int level = nodeInfo.level;
            TreeNode node = nodeInfo.node;
            if (level > result.size() - 1)
                result.add(new LinkedList<>());
            result.get(level).add(node.val);

            if (node.right != null)
                stack.push(new NodeInfo(level + 1, node.right));
            if (node.left != null)
                stack.push(new NodeInfo(level + 1, node.left));
        }

        return result;
    }

    /**
     * Official Version
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return List.of();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        int level = 0;
        while (!stack.isEmpty()) {
            result.add(new ArrayList<>());
            int stackSize = stack.size();
            for (int i = 0; i < stackSize; i++) {
                TreeNode node = stack.removeLast();
                result.get(level).add(node.val);
                if (node.left != null)
                    stack.push(node.left);
                if (node.right != null)
                    stack.push(node.right);
            }
            level++;
        }
        return result;
    }


    public static void main(String[] args) {

        TreeNode input = new TreeNode(
                3,
                new TreeNode(9,
                        new TreeNode(10),
                        new TreeNode(11)
                ),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        printInput(input);
        printOutput(
                "    Mine", new m102_BinaryTreeLevelOrderTraversal().levelOrderMine(input),
                "Official", new m102_BinaryTreeLevelOrderTraversal().levelOrder(input)
        );
    }
}
