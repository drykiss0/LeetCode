package org.evoludev.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class E28_ImplementStrStr {

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

    @Test
    public void test() {
        String haystack = "mississippi";
        String needle = "issip";

        System.out.println("strStr(" + haystack + ", " + needle + ") = " + strStr(haystack, needle));
    }
}