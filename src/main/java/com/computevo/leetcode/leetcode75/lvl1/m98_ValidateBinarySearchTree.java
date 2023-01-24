package com.computevo.leetcode.leetcode75.lvl1;

import com.computevo.leetcode.helper.TreeNode;

import java.util.LinkedList;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan&id=level-1">link</a>
 */
public class m98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        Integer prevVal = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode popped = stack.pop();
                if (prevVal != null && popped.val < prevVal)
                    return false;
                prevVal = popped.val;
                node = popped.right;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        TreeNode input = new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(8)
                )
        );

        printInput(input);
        printOutput(new m98_ValidateBinarySearchTree().isValidBST(input));
    }
}
