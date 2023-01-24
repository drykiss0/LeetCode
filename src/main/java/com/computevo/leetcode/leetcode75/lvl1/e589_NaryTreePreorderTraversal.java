package com.computevo.leetcode.leetcode75.lvl1;

import com.computevo.leetcode.helper.Node;
import com.computevo.leetcode.helper.Utils;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/?envType=study-plan&id=level-1">link</a>
 */
public class e589_NaryTreePreorderTraversal {

    public List<Integer> preorderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private void preorderRecursive(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            node.children.forEach(child -> preorderRecursive(child, result));
        }
    }

    // Better solution - iterative

    public List<Integer> preorder(Node root) {

        if (root == null) return List.of();
        List<Integer> results = new LinkedList<>();
        LinkedList<Node> nodeStack = new LinkedList<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            results.add(node.val);
            Collections.reverse(node.children);
            node.children.forEach(nodeStack::push);
        }
        return results;
    }


    public static void main(String[] args) {

        Node input = new Node(1,
                Arrays.asList(new Node(3,
                                Arrays.asList(
                                        new Node(5),
                                        new Node(6))
                        ),
                        new Node(2),
                        new Node(4)
                )
        );

        Utils.printInput(input);
        Utils.printOutput(
                "Recursive", new e589_NaryTreePreorderTraversal().preorderRecursive(input),
                "Iterative", new e589_NaryTreePreorderTraversal().preorder(input)
        );
    }
}
