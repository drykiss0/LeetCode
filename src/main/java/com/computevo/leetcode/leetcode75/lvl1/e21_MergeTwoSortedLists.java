package com.computevo.leetcode.leetcode75.lvl1;

import com.computevo.leetcode.helper.ListNode;

import static com.computevo.leetcode.helper.Utils.*;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan&id=level-1">link</a>
 */
public class e21_MergeTwoSortedLists {

    /**
     * LettCode's official solution for reference
     */
    @SuppressWarnings("unused")
    public ListNode official_mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list2 == null) return list1;
        list1 = new ListNode(0, list1);
        ListNode result = list1;
        while (list1.next != null) {
            if (list1.next.val > list2.val) {
                ListNode temp = list1.next;
                list1.next = list2;
                list2 = temp;
            } else {
                list1 = list1.next;
            }
        }
        list1.next = list2;
        return result.next;
    }

    public static void main(String[] args) {

        ListNode list1 = parseListNodes("[]");
        ListNode list2 = parseListNodes("[]");

        printInput("list1", list1, "list2", list2);
        printOutput(
                new e21_MergeTwoSortedLists().mergeTwoLists(list1, list2)
        );
    }
}
