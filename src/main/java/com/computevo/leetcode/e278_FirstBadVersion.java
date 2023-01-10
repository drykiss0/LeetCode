package com.computevo.leetcode;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/first-bad-version/?envType=study-plan&id=level-1">link</a>
 */
public class e278_FirstBadVersion {

    private final boolean[] versions;

    public e278_FirstBadVersion(boolean[] versions) {
        this.versions = versions;
    }

    private boolean isBadVersion(int version) {
        if (version <= 0 || version > versions.length)
            throw new IllegalArgumentException("Bad version: " + version);
        return versions[version - 1];
    }

    public int firstBadVersionMine(int numVersions) {
        int left = 1;
        int right = numVersions;
        int pivot = -1;
        boolean isBad = false;
        while (right >= left) {
            // pivot = (left + right) / 2;
            pivot = left + (right - left) / 2; // <------ avoid overflow !!!
            isBad = isBadVersion(pivot);
            if (isBad)
                right = pivot - 1;
            else
                left = pivot + 1;
        }

        return isBad ? pivot : (numVersions == pivot ? -1 : pivot + 1);
    }

    /** Official Version */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int versionsNum = 2126753390;
        int bad = 1702766719;
        boolean[] badVersions = new boolean[versionsNum];
        for (int i = bad - 1; i < badVersions.length; i++) {
            badVersions[i] = true;
        }

        printInput("versionsNum", versionsNum, "bad", bad);//, "badVersions", badVersions);
        printOutput(
                "Mine", new e278_FirstBadVersion(badVersions).firstBadVersionMine(versionsNum),
                "Official", new e278_FirstBadVersion(badVersions).firstBadVersion(versionsNum)
        );
    }
}
