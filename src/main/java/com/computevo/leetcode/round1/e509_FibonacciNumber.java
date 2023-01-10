package com.computevo.leetcode.round1;

public class e509_FibonacciNumber {

    public int fib(int N) {
        int prevFib = 1;
        int fib = 0;
        for (int i = 1; i <= N; i++) {
            fib = fib + prevFib;
            prevFib = fib - prevFib;
        }
        return fib;
    }


    public static void main(String[] args) {

        int num = 4;// output:3
        System.out.println("fib(" + num + ") = " + new e509_FibonacciNumber().fib(num));
    }
}
