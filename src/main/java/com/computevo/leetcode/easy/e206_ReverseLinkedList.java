package com.computevo.leetcode.easy;

import com.computevo.leetcode.easy.helper.ListNode;

import static com.computevo.leetcode.easy.helper.Utils.*;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/?envType=study-plan&id=level-1">link</a>
 */
public class e206_ReverseLinkedList {

    public ListNode reverseListRecursive(ListNode left, ListNode right) {
        if (right == null) return left;
        ListNode temp = right.next;
        right.next = left;
        return reverseListRecursive(right, temp);
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode curr = null;
        ListNode next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        return curr;
    }

    public static void main(String[] args) {

        String input = "[1, 2, 3, 4]";
        printInput(parseListNodes(input));

        ListNode iterativeResult = new e206_ReverseLinkedList().reverseListIterative(parseListNodes(input));
        ListNode recurrentResult = new e206_ReverseLinkedList().reverseListRecursive(null, parseListNodes(input));

        printOutput(
                "Iterative", iterativeResult,
                "Recursive", recurrentResult
        );
    }
}
