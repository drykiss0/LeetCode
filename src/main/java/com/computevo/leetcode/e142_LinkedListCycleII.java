package com.computevo.leetcode;

import com.computevo.leetcode.helper.ListNode;
import com.computevo.leetcode.helper.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii/?envType=study-plan&id=level-1">link</a>
 */
public class e142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        Map<ListNode, Integer> nodeIdxMap = new HashMap<>();
        ListNode curr = head;
        for (int i = 0; curr != null; i++, curr = curr.next) {
            if (nodeIdxMap.containsKey(curr)) return curr;
            nodeIdxMap.put(curr, i);
        }
        return null;
    }

    public static void main(String[] args) {

        String input = "[3,2,0,-4]";
        int pos = 1;

        ListNode head = Utils.parseListNodes(input).withCycleTo(pos);


        Utils.printInput(head);
        ListNode result = new e142_LinkedListCycleII().detectCycle(head);

        Utils.printOutput("Cycle start", result);
    }
}
