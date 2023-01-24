package com.computevo.leetcode.leetcode75.lvl1;

import static com.computevo.leetcode.helper.Utils.printSolution;

/**
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/">link</a>
 */
public class e1342_NumberOfStepsToReduceNumberToZero {

    public int numberOfSteps(int num) {

        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num ^= 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {

        int n = 14;

        int result = new e1342_NumberOfStepsToReduceNumberToZero().numberOfSteps(n);

        printSolution(n, result);
    }
}
