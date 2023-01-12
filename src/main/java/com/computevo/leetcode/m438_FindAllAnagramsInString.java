package com.computevo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/?envType=study-plan&id=level-1">link</a>
 */
public class m438_FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (sLength == 0 || pLength == 0 || sLength < pLength) return List.of();
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pMap = freqMap(p, pLength);

        int right = pLength - 1;
        Map<Character, Integer> sMap = freqMap(s, pLength - 1);

        while (right < sLength) {
            char rightCh = s.charAt(right);
            sMap.compute(rightCh, (k, v) -> v == null ? 1 : v + 1);

            if (sMap.equals(pMap)) {
                result.add(right - pLength + 1);
            }

            char leftCh = s.charAt(right - pLength + 1);
            sMap.compute(leftCh, (k, v) -> v == null || v == 1 ? null : v - 1);

            right++;
        }
        return result;
    }

    private Map<Character, Integer> freqMap(String str, int to) {
        HashMap<Character, Integer> result = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < to; i++) {
            result.compute(chars[i], (k, v) -> (v == null) ? 1 : v + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        printInput("s", s, "p", p);
        printOutput(
                "findAnagrams(s,p)", new m438_FindAllAnagramsInString().findAnagrams(s, p)
        );
    }
}
