package com.computevo.leetcode.helper;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

    public static String toNiceString(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        return printNodeInternal(Collections.singletonList(root), 1, maxLevel).insert(0, "\n").toString();
    }

    private static StringBuilder printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        StringBuilder sb = new StringBuilder();
        if (nodes.isEmpty() || ObjectUtils.allNull(nodes.toArray()))
            return sb;
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        sb.append(StringUtils.repeat(" ", firstSpaces));

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                sb.append(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                sb.append(" ");
            }

            sb.append(StringUtils.repeat(" ", betweenSpaces));
        }
        sb.append("\n");

        for (int i = 1; i <= edgeLines; i++) {
            for (TreeNode node : nodes) {
                sb.append(StringUtils.repeat(" ", firstSpaces - i));
                if (node == null) {
                    sb.append(StringUtils.repeat(" ", edgeLines + edgeLines + i + 1));
                    continue;
                }

                if (node.left != null)
                    sb.append("/");
                else
                    sb.append(" ");

                sb.append(StringUtils.repeat(" ", i + i - 1));

                if (node.right != null)
                    sb.append("\\");
                else
                    sb.append(" ");

                sb.append(StringUtils.repeat(" ", edgeLines + edgeLines - i));
            }

            sb.append("\n");
        }

        sb.append(printNodeInternal(newNodes, level + 1, maxLevel));

        return sb;
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }
}
