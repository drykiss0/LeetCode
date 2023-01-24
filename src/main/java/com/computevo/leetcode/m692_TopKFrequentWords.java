package com.computevo.leetcode;

import java.util.*;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words/?envType=study-plan&id=level-1">link</a>
 */
public class m692_TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word: words) {
            freqMap.compute(word, (w, f) -> f == null ? 1 : f + 1);
        }
        Comparator<Map.Entry<String, Integer>> comparator =
                Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey());
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comparator);
        for (Map.Entry<String, Integer> entry: freqMap.entrySet()) {
            pq.offer(entry);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {

        String[] words1 = {"i","love","leetcode","i","love","coding"};
        int k1 = 2;
        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k2 = 4;

        printInput("words", "k", new Object[][]{
                new Object[] { words1, k1},
                new Object[] { words2, k2}
        });
        printOutput(
                "topKFrequent(1)", new m692_TopKFrequentWords().topKFrequent(words1, k1),
                "topKFrequent(2)", new m692_TopKFrequentWords().topKFrequent(words2, k2)
        );
    }
}
