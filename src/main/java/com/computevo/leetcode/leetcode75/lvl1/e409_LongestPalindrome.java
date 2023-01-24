package com.computevo.leetcode.leetcode75.lvl1;

import com.computevo.leetcode.helper.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/fizz-buzz/">link</a>
 */
public class e409_LongestPalindrome {

    public int longestPalindrome(String input) {
        Map<Character, Integer> charOddEvenMap = new HashMap<>();
        input.chars().forEach(inputChar ->
                charOddEvenMap.compute((char) inputChar, (ch, count) -> (count == null) ? 1 : (count + 1) % 2)
        );

        int oddCount = (int) charOddEvenMap.values().stream().filter(c -> c != 0).count();
        return oddCount > 0 ? input.length() - oddCount + 1 : input.length();
    }

    public static void main(String[] args) {

        String input = "bb";

        int result = new e409_LongestPalindrome().longestPalindrome(input);

        Utils.printSolution(input, result);
    }
}
