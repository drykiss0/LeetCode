package com.computevo.leetcode;

import com.computevo.leetcode.helper.TreeNode;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/?envType=study-plan&id=level-1">link</a>
 */
public class m235_LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val > q.val && root.val > p.val)
            return lowestCommonAncestor_recursive(root.left, p, q);
        else if (root.val < q.val && root.val < p.val) {
            return lowestCommonAncestor_recursive(root.right, p, q);
        } else return root;
    }

    public TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > q.val && root.val > p.val)
                root = root.left;
            else if (root.val < q.val && root.val < p.val) {
                root = root.right;
            } else return root;
        }
        return null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );
        TreeNode p = root.left.right.left;
        TreeNode q = root.left.right.right;

        printInput("root", root, "p", p.val, "q", q.val);
        printOutput(
                "Recursive", new m235_LowestCommonAncestorOfBinarySearchTree().lowestCommonAncestor_recursive(root, p, q).val,
                "Iterative", new m235_LowestCommonAncestorOfBinarySearchTree().lowestCommonAncestor_iterative(root, p, q).val
        );
    }
}
