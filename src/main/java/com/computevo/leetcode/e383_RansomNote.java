package com.computevo.leetcode;

import com.computevo.leetcode.helper.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/ransom-note/">link</a>
 */
public class e383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letterMap = new HashMap<>();

        magazine.chars().forEach(c -> letterMap.compute((char) c, (k, v) -> (v == null) ? 1 : v + 1));

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int lettersLeft = letterMap.getOrDefault(c, 0);
            if (lettersLeft == 0) return false;
            else letterMap.put(c, --lettersLeft);
        }
        return true;
    }

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println("ransomNote = " + ransomNote + " magazine = " + magazine);
        boolean result = new e383_RansomNote().canConstruct(ransomNote, magazine);

        Utils.printSolution(
                new Object[][]{{"ransomNote", ransomNote}, {"magazine", magazine}},
                result
        );
    }
}
