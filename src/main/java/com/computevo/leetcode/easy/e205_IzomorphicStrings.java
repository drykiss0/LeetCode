package com.computevo.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/isomorphic-strings/?envType=study-plan&id=level-1
 */
public class e205_IzomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;
        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);

            if (!sToTMapping.containsKey(sChar))
                sToTMapping.put(sChar, tChar);
            if (!tToSMapping.containsKey(tChar))
                tToSMapping.put(tChar, sChar);

            if (!sToTMapping.get(sChar).equals(tChar) || !tToSMapping.get(tChar).equals(sChar))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "badc";
        String t = "baba";

        boolean result = new e205_IzomorphicStrings().isIsomorphic(s, t);
        printSolution(
                new Object[][]{{"s", s}, {"t", t}},
                result
        );
    }
}
