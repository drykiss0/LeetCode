package com.computevo.leetcode;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/?envType=study-plan&id=level-1">link</a>
 */
public class m424_LongestRepeatingCharacterReplacement {

    @SuppressWarnings("unused")
    public int characterReplacement_notCorrect(String s, int k) {
        int length = s.length();
        if (k + 1 >= length) return length;

        int remainingK = k;
        int max = 0;
        int left = 0;
        int right = 0;
        int firstDiffLetterIdx = 0;
        while (right < length) {

            while (right < length && s.charAt(right) == s.charAt(left)) right++;
            if (firstDiffLetterIdx == 0) {
                firstDiffLetterIdx = right;
            }
            if (remainingK > 0) {
                right++;
            } else {
                max = Math.max(max, right - left);
                remainingK = Math.max(k, 1);
                left = firstDiffLetterIdx;
                right = firstDiffLetterIdx;
                firstDiffLetterIdx = 0;
            }
            remainingK--;
        }

        return Math.min(Math.max(max, right - left) + remainingK, length);
    }

    /**
     * Official solution
     */
    public int characterReplacement(String s, int k) {

        int length = s.length();
        if (length < 2) return length;

        int[] freqMap = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxSubstring = 0;
        for (int right = 0; right < length; right++) {

            int mapIdx = s.charAt(right) - 'A';
            freqMap[mapIdx]++;
            maxFreq = Math.max(maxFreq, freqMap[mapIdx]);

            // Window validity condition
            boolean isWindowValid = right - left + 1 - maxFreq <= k;
            if (!isWindowValid) {
                freqMap[s.charAt(left) - 'A']--;
                left++;
            } else {
                maxSubstring = right - left + 1;
            }
        }
        return maxSubstring;
    }

    public static void main(String[] args) {
        String s1 = "ABBB";
        int k1 = 2;
        String s2 = "AABABBA";
        int k2 = 1;
        String s3 = "AABABBBBBA";
        int k3 = 0;

        printInput("s1", s1, "k1", k1, "s2", s2, "k2", k2, "s3", s3, "k3", k3);
        printOutput(
                "characterReplacement(s1,k1)", new m424_LongestRepeatingCharacterReplacement().characterReplacement(s1, k1),
                "characterReplacement(s2,k2)", new m424_LongestRepeatingCharacterReplacement().characterReplacement(s2, k2),
                "characterReplacement(s3,k3)", new m424_LongestRepeatingCharacterReplacement().characterReplacement(s3, k3)
        );
    }
}
