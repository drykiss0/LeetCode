package com.computevo.leetcode.explore.google;

import java.util.*;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/odd-even-jump/description/">link</a>
 */
public class h975_OddEvenJump {

    public int oddEvenJumps(int[] arr) {
        Integer[] indexesForSortedArr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            indexesForSortedArr[i] = i;
        }

        Arrays.sort(indexesForSortedArr, Comparator.comparingInt(k -> arr[k]));
        Map<Integer, Integer> oddJumpCache = buildJumpCache(indexesForSortedArr);

        Arrays.sort(indexesForSortedArr, Comparator.comparing(k -> arr[k], Comparator.reverseOrder()));
        Map<Integer, Integer> evenJumpCache = buildJumpCache(indexesForSortedArr);

        Map<Boolean, Map<Integer, Integer>> jumpCaches = new HashMap<>();
        jumpCaches.put(true, oddJumpCache);
        jumpCaches.put(false, evenJumpCache);
        for (int i = 0; i < arr.length - 1; i++) {
            performJump(i, jumpCaches, true);
        }
        return jumpCaches.get(true).size();
    }

    public Integer performJump(Integer from, Map<Boolean, Map<Integer, Integer>> jumpCaches, boolean isOdd) {
        if (from == null || from == Integer.MAX_VALUE) {
            return from;
        }
        Integer result = performJump(jumpCaches.get(isOdd).get(from), jumpCaches, !isOdd);
        if (result == null) {
            jumpCaches.get(isOdd).remove(from);
        }
        return result;
    }

    public Map<Integer, Integer> buildJumpCache(Integer[] arrIndexes) {
        Map<Integer, Integer> jumpCache = new HashMap<>();
        jumpCache.put(arrIndexes.length - 1, Integer.MAX_VALUE);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arrIndexes.length - 1; i++) {
            while (!pq.isEmpty() && pq.peek() < arrIndexes[i + 1]) {
                jumpCache.put(pq.poll(), arrIndexes[i + 1]);
            }
            if (arrIndexes[i + 1] > arrIndexes[i]) {
                jumpCache.put(arrIndexes[i], arrIndexes[i + 1]);
            } else {
                pq.offer(arrIndexes[i]);
            }
        }
        return jumpCache;
    }

    public static void main(String[] args) {

        int[] arr1 = {10,13,12,14,15};
        int[] arr2 = {2,3,1,1,4};
        int[] arr3 = {5,1,3,4,2};


        printInput("arr", new Object[]{arr1, arr2, arr3});
        printOutput(
                "oddEvenJumps1", new h975_OddEvenJump().oddEvenJumps(arr1),
                "oddEvenJumps2", new h975_OddEvenJump().oddEvenJumps(arr2),
                "oddEvenJumps3", new h975_OddEvenJump().oddEvenJumps(arr3)
        );
    }
}
