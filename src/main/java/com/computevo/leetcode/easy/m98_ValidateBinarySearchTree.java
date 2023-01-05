package com.computevo.leetcode.easy;

import com.computevo.leetcode.easy.helper.TreeNode;

import static com.computevo.leetcode.easy.helper.Utils.printInput;
import static com.computevo.leetcode.easy.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan&id=level-1">link</a>
 */
public class m98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return false;
    }


    public static void main(String[] args) {

        TreeNode input = new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)
                )
        );

        printInput(input);
        printOutput(
                "    Mine", new m98_ValidateBinarySearchTree().isValidBST(input),
                "Official", new m98_ValidateBinarySearchTree().isValidBST(input)
        );
    }
}
