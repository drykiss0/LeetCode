package com.computevo.leetcode;

import com.computevo.leetcode.helper.BTreePrinter;
import com.computevo.leetcode.helper.TreeNode;

import java.util.*;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description">link</a>
 */
public class m236_LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode node = root;
        parents.put(node, null);
        stack.push(node);
        while (!(parents.containsKey(p) && parents.containsKey(q))) {
            node = stack.pop();
            // printDebug(node.val);
            if (node.right != null) {
                parents.put(node.right, node);
                stack.push(node.right);
            }
            if (node.left != null) {
                parents.put(node.left, node);
                stack.push(node.left);
            }
        }
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parents.get(p);
        }

        while (!pAncestors.contains(q)) {
            q = parents.get(q);
        }

        return q;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)
                )
        );
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(4);

        printInput("tree", BTreePrinter.toNiceString(root), "root", root, "p", p.val, "q", q.val);
        printOutput(new m236_LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, p, q).val);
    }
}
