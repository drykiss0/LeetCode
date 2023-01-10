package com.computevo.leetcode;

import com.computevo.leetcode.helper.ListNode;

import static com.computevo.leetcode.helper.Utils.*;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/?envType=study-plan&id=level-1">link</a>
 */
public class e876_2_MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        String input = "[1, 2, 3, 4]";
        ListNode head = parseListNodes(input);

        printInput(head);
        ListNode result = new e876_2_MiddleOfLinkedList().middleNode(head);

        printOutput(result);
    }
}
