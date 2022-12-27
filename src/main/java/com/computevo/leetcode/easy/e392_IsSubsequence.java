package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan&id=level-1
 */
public class e392_IsSubsequence {

    public boolean isSubsequence(String src, String trg) {

        int srcIdx = 0;
        for (int i = 0; i < trg.length() && srcIdx < src.length(); i++) {
            if (src.charAt(srcIdx) == trg.charAt(i)) srcIdx++;
        }

        return srcIdx == src.length();
    }

    public static void main(String[] args) {

        String s = "axc";
        String t = "ahbgdc";

        boolean result = new e392_IsSubsequence().isSubsequence(s, t);
        printSolution(
                new Object[][]{{"s", s}, {"t", t}},
                result
        );
    }
}
