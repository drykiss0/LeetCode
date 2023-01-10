package com.computevo.leetcode.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Node {
    public final int val;
    public List<Node> children = new ArrayList<>();

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    @Override
    public String toString() {
        return "[" + String.join(Utils.DELIM, String.valueOf(val), toStringChildren().collect(Collectors.joining(Utils.DELIM)))  + "]";
    }

    private Stream<String> toStringChildren() {
        return !children.isEmpty() ? Stream.concat(
                Stream.concat(
                        Stream.of("null"),
                        children.stream().map(n -> String.valueOf(n.val))
                ),
                children.stream().flatMap(Node::toStringChildren)
        ) : Stream.empty();
    }
}
