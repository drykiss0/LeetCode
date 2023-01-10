package com.computevo.leetcode;

import com.computevo.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/fizz-buzz/">link</a>
 */
public class e412_FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            StringBuilder elem = new StringBuilder();
            if (i % 3 == 0) {
                elem.append("Fizz");
            }
            if (i % 5 == 0) {
                elem.append("Buzz");
            }
            if (elem.isEmpty()) {
                elem.append(i);
            }
            result.add(elem.toString());
        }
        return result;
    }

    public static void main(String[] args) {

        int n = 3;

        List<String> result = new e412_FizzBuzz().fizzBuzz(n);

        Utils.printSolution(n, result);
    }
}
