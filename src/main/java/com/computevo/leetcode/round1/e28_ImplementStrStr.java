package com.computevo.leetcode.round1;

public class e28_ImplementStrStr {

    public int strStr(String haystack, String needle) {

        if ("".equals(needle)) {
            return 0;
        }
        int needleIdxToCheck = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(needleIdxToCheck)) {
                needleIdxToCheck++;
            } else {
                i -= needleIdxToCheck;
                needleIdxToCheck = 0;
            }
            if (needleIdxToCheck == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return haystack.indexOf(needle);
    }


    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";

        System.out.println("strStr(" + haystack + ", " + needle + ") = " + new e28_ImplementStrStr()
                .strStr(haystack, needle));
    }
}
