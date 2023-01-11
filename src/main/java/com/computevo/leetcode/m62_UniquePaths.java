package com.computevo.leetcode;

import java.util.Arrays;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/unique-paths/?envType=study-plan&id=level-1">link</a>
 */
public class m62_UniquePaths {

    /**
     * Mine - Top-Down approach
     */
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[Math.min(m, n)][Math.max(m, n)];
        return uniquePaths(m - 1, n - 1, cache);
    }

    private int uniquePaths(int m, int n, int[][] cache) {
        if (m == 0 || n == 0) return 1;
        if (cache[Math.min(m, n)][Math.max(m, n)] > 0) return cache[Math.min(m, n)][Math.max(m, n)];

        int prevUniquePaths = 0;
        for (int i = m - 1; i >= 0; i--)
            prevUniquePaths += uniquePaths(i, n - 1, cache);
        for (int i = n - 1; i >= 0; i--)
            prevUniquePaths += uniquePaths(m - 1, i, cache);

        cache[Math.min(m, n)][Math.max(m, n)] = prevUniquePaths;
        return prevUniquePaths;
    }

    /**
     * Official - Bottom-Up approach
     */
    @SuppressWarnings("unused")
    public int uniquePathsOfficial(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        printInput("m", m, "n", n);
        printOutput(
                "uniquePaths(m,n)", new m62_UniquePaths().uniquePaths(m, n),
                "_Official_", new m62_UniquePaths().uniquePathsOfficial(m, n)
        );
    }
}
