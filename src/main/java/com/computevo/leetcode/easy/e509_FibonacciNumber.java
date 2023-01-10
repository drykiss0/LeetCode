package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printInput;
import static com.computevo.leetcode.easy.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/fibonacci-number/?envType=study-plan&id=level-1">link</a>
 */
public class e509_FibonacciNumber {

    public int fibRecursive(int n) {
        if (n < 2) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public int fibWithCache(int n) {
        if (n < 2) return n;
        int[] fib = new int[n+1];
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public int fibIterative(int n) {
        if (n < 2) return n;
        int prev2 = 0;
        int prev1 = 1;
        int fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = prev1 + prev2;
            prev2 = prev1;
            prev1 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {

        int n = 7;

        printInput("n", n);
        printOutput(
                "fibRecursive(n)", new e509_FibonacciNumber().fibRecursive(n),
                "fibWithCache(n)", new e509_FibonacciNumber().fibWithCache(n),
                "fibIterative(n)", new e509_FibonacciNumber().fibIterative(n)
        );
    }
}
