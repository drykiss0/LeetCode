package com.computevo.leetcode.leetcode75.lvl1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/?envType=study-plan&id=level-1">link</a>
 */
public class e1046_LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        Arrays.stream(stones).forEach(pq::offer);

        int sum;
        while (pq.size() > 1) {
            sum = pq.poll() - pq.poll();
            if (sum > 0) {
                pq.offer(sum);
            }
        }
        return !pq.isEmpty() ? pq.peek() : 0;
    }

    public static void main(String[] args) {

        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1};

        printInput("stones", new Object[]{stones1, stones2});
        printOutput(
                "lastStoneWeight(1)", new e1046_LastStoneWeight().lastStoneWeight(stones1),
                "lastStoneWeight(2)", new e1046_LastStoneWeight().lastStoneWeight(stones2)
        );
    }
}
