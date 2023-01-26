package com.computevo.leetcode.explore.google;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/license-key-formatting/description/">link</a>
 */
public class e482_LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int currentCharsInGroup = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != '-') {
                if (currentCharsInGroup == k) {
                    sb.append('-');
                    currentCharsInGroup = 0;
                }
                sb.append(Character.toUpperCase(ch));
                currentCharsInGroup++;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String s1 = "5F3Z-2e-9-w";
        int k1 = 4;
        String s2 = "2-5g-3-J";
        int k2 = 2;

        printInput("s", "k", new Object[][]{new Object[]{s1, k1}, new Object[]{s2, k2}});
        printOutput(
                "licenseKeyFormatting1", new e482_LicenseKeyFormatting().licenseKeyFormatting(s1, k1),
                "licenseKeyFormatting2", new e482_LicenseKeyFormatting().licenseKeyFormatting(s2, k2)
        );
    }
}
