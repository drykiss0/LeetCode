package org.evoludev.easy;

import org.junit.Test;

public class E70_ClimbingStairs {

    public int climbStairs(int n) {

        int prevFib = 1;
        int fib = 0;

        for (int i = 1; i <= n+1; i++) {
            fib = fib + prevFib;
            prevFib = fib - prevFib;
        }
        return fib;
    }


    @Test
    public void test() {

        int num = 4;// output:5
        System.out.println("climbStairs(" + num + ") = " + climbStairs(num));
    }
}