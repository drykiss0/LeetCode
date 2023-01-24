package com.computevo.leetcode.leetcode75.lvl1;

import java.util.LinkedList;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/decode-string/?envType=study-plan&id=level-1">link</a>
 */
public class m394_DecodeString {

    private final LinkedList<Integer> openBrackets = new LinkedList<>();

    public String decodeString(String s) {
        return decodeString(s, 1, 0, s.length()).toString();
    }

    public StringBuilder decodeString(String s, int repeat, int from, int to) {
        if (repeat < 1) return new StringBuilder(0);
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = from; i < to; i++) {
            ch = s.charAt(i);
            if (ch >= 'a') {
                sb.append(ch);
            } else if (ch == '[') {
                openBrackets.add(i);
            } else if (ch == ']') {
                int openBracketIdx = openBrackets.removeLast();
                int numStartIdx = openBracketIdx - 1;
                while (numStartIdx >= 0 && s.charAt(numStartIdx) - '0' <= 9) {
                    numStartIdx--;
                }
                int repeats = Integer.parseInt(s.substring(numStartIdx + 1, openBracketIdx)) - 1;
                sb.append(
                        decodeString(s, repeats, openBracketIdx + 1, i)
                );
            }
        }
        if (repeat > 1) {
            String single = sb.toString();
            sb.append(single.repeat(repeat - 1));
        }
        return sb;
    }

    /**
     * Official Solution
     */
    @SuppressWarnings("unused")
    static class Solution {
        int index = 0;

        public String decodeString(String s) {
            StringBuilder result = new StringBuilder();
            while (index < s.length() && s.charAt(index) != ']') {
                if (!Character.isDigit(s.charAt(index)))
                    result.append(s.charAt(index++));
                else {
                    int k = 0;
                    // build k while next character is a digit
                    while (index < s.length() && Character.isDigit(s.charAt(index)))
                        k = k * 10 + s.charAt(index++) - '0';
                    // ignore the opening bracket '['
                    index++;
                    String decodedString = decodeString(s);
                    // ignore the closing bracket ']'
                    index++;
                    // build k[decodedString] and append to the result
                    while (k-- > 0)
                        result.append(decodedString);
                }
            }
            return new String(result);
        }
    }

    public static void main(String[] args) {
        String s1 = "100[leetcode]";
        String s2 = "3[a]2[bc]";
        String s3 = "3[a2[c]]";
        String s4 = "2[abc]3[cd]ef";

        printInput("s", new Object[]{s1, s2, s3, s4});
        printOutput(
                "decodeString(1)", new m394_DecodeString().decodeString(s1),
                "decodeString(2)", new m394_DecodeString().decodeString(s2),
                "decodeString(3)", new m394_DecodeString().decodeString(s3),
                "decodeString(4)", new m394_DecodeString().decodeString(s4)
        );
    }
}
