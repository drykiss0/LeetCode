package org.evoludev.easy;

import org.junit.Test;

public class E70_ClimbingStairs {

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        int prevFib = 1;
        int prevPrevFib = 1;
        int fib = prevFib + prevPrevFib;

        for (int i = 3; i <= n; i++) {
            prevPrevFib = prevFib;
            prevFib = fib;
            fib = prevFib + prevPrevFib;
        }
        return fib;
    }


    @Test
    public void test() {

        int num = 3;// output:3
        System.out.println("climbStairs(" + num + ") = " + climbStairs(num));
    }
}