package com.computevo.leetcode.easy.round1;

public class e70_ClimbingStairs {

    public int climbStairs(int n) {

        int prevFib = 1;
        int fib = 0;

        for (int i = 1; i <= n + 1; i++) {
            fib = fib + prevFib;
            prevFib = fib - prevFib;
        }
        return fib;
    }


    public static void main(String[] args) {

        int num = 4;// output:5
        System.out.println("climbStairs(" + num + ") = " + new e70_ClimbingStairs().climbStairs(num));
    }
}
