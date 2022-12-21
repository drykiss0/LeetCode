package com.computevo.leetcode.easy.round1;

public class e38_CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        final String prevSay = countAndSay(n - 1);
        char countChar = prevSay.charAt(0);
        int count = 1;

        final StringBuilder result = new StringBuilder();
        for (int i = 1; i < prevSay.length(); i++) {
            if (prevSay.charAt(i) == countChar) {
                count++;
            } else {
                result.append(count).append(countChar);
                countChar = prevSay.charAt(i);
                count = 1;
            }
        }
        return result.append(count).append(countChar).toString();
    }


    public static void main(String[] args) {

        int n = 5;
        System.out.println("countAndSay(" + n + ") = " + new e38_CountAndSay().countAndSay(n));
    }
}
