package com.computevo.leetcode.easy;

import com.computevo.leetcode.easy.helper.ListNode;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class e876_MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {

        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int pos = (size-1) / 2 + (size-1) % 2;
        for (int i = 0; i < pos; i++) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = new e876_MiddleOfLinkedList().middleNode(list);

        printSolution(list, result);
    }
}
