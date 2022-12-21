package com.computevo.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import static com.computevo.leetcode.easy.helper.Utils.printSolution;

/**
 * https://leetcode.com/problems/fizz-buzz/
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

        printSolution(n, result);
    }
}
