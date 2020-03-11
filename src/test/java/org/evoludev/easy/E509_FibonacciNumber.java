package org.evoludev.easy;

import org.junit.Test;

public class E509_FibonacciNumber {

    public int fib(int N) {
        int prevFib = 1;
        int fib = 0;
        for (int i = 1; i <= N; i++) {
            fib = fib + prevFib;
            prevFib = fib - prevFib;
        }
        return fib;
    }


    @Test
    public void test() {

        int num = 4;// output:3
        System.out.println("fib(" + num + ") = " + fib(num));
    }
}