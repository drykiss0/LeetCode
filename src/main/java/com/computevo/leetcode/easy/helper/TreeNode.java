package com.computevo.leetcode.easy.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.computevo.leetcode.easy.helper.Utils.DELIM;
import static java.util.Optional.ofNullable;

public class TreeNode {
    public static final String NULL_STR = "null";
    public int val;
    public TreeNode left;
    public TreeNode right;
    private List<TreeNode> children = List.of();

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.children = List.of(left, right);
    }

    @Override
    public String toString() {
        String[] nodesStr = toStringChildren(this).toArray(String[]::new);
        for (int i = nodesStr.length - 1; i >= 0 && nodesStr[i].equals(NULL_STR); i--) {
            nodesStr[i] = null;
        }

        return "[" + String.join(
                DELIM,
                String.valueOf(val),
                Arrays.stream(nodesStr).filter(Objects::nonNull).collect(Collectors.joining(DELIM))
        ) + "]";
    }

    private static String strVal(TreeNode node) {
        return ofNullable(node).map(v -> String.valueOf(v.val)).orElse(NULL_STR);
    }

    private static Stream<String> toStringChildren(TreeNode node) {
        if (node == null) return Stream.empty();
        return Stream.concat(
                Stream.of(strVal(node.left), strVal(node.right)),
                Stream.concat(
                        toStringChildren(node.left),
                        toStringChildren(node.right)
                )
        );
    }
}
