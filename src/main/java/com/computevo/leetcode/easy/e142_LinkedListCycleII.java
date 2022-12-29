package com.computevo.leetcode.easy;

import com.computevo.leetcode.easy.helper.ListNode;

import java.util.HashMap;
import java.util.Map;

import static com.computevo.leetcode.easy.helper.Utils.*;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/?envType=study-plan&id=level-1
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

        ListNode head = parseListNodes(input).withCycleTo(pos);


        printInput(head);
        ListNode result = new e142_LinkedListCycleII().detectCycle(head);

        printOutput("Cycle start", result);
    }
}
