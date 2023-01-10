package com.computevo.leetcode.round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class e118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        if (numRows < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public String formattedTriangle(List<List<Integer>> triangle) {
        StringBuilder b = new StringBuilder("\n[\n");
        int rowNum = triangle.size();
        for (List<Integer> row : triangle) {
            b.append(String.format("%" + rowNum-- + "s", "")).append(row).append(",\n");
        }
        b.append("]\n");
        return b.toString();
    }


    public static void main(String[] args) {

        e118_PascalsTriangle obj = new e118_PascalsTriangle();

        int numRows = 5;
        System.out.println("generate(" + numRows + ") = " + obj.formattedTriangle(obj.generate(numRows)));
    }
}
