package com.computevo.leetcode.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListNode {
    private int cycledToIndex = -1;
    public final int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" + asList().stream().map(ListNode::toValString).collect(Collectors.joining(", ")) + "]";
    }

    private String toValString() {
        return cycledToIndex < 0 ? String.valueOf(val) : String.format("%s |↺%s", val, cycledToIndex);
    }

    public List<ListNode> asList() {
        List<ListNode> result = new ArrayList<>();
        ListNode curr = this;
        while (curr != null) {
            result.add(curr);
            if (curr.cycledToIndex < 0)
                curr = curr.next;
            else
                curr = null;
        }
        return result;
    }

    public ListNode withCycleTo(int idx) {
        List<ListNode> list = asList();
        list.get(list.size() - 1).cycledToIndex = idx;
        list.get(list.size() - 1).next = list.get(idx);
        return this;
    }
}
