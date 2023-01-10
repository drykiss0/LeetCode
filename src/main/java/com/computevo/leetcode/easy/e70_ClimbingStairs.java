package com.computevo.leetcode.easy;

import static com.computevo.leetcode.easy.helper.Utils.printInput;
import static com.computevo.leetcode.easy.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/?envType=study-plan&id=level-1">link</a>
 */
public class e70_ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev2 = 1;
        int prev1 = 2;
        int fib = 0;
        for (int i = 3; i <= n; i++) {
            fib = prev1 + prev2;
            prev2 = prev1;
            prev1 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {

        int n = 5;

        printInput("n", n);
        printOutput(
                "climbStairs(n)", new e70_ClimbingStairs().climbStairs(n)
        );
    }
}
