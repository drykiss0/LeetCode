package com.computevo.leetcode.leetcode75.lvl1;

import java.util.LinkedList;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/?envType=study-plan&id=level-1">link</a>
 */
public class e844_BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return edited(s).equals(edited(t));
    }

    private LinkedList<Integer> edited(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#')
                stack.push((int) s.charAt(i));
            else if (!stack.isEmpty())
                stack.pop();
        }
        return stack;
    }

    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";
        String s2 = "ab##";
        String t2 = "c#d#";
        String s3 = "a#c";
        String t3 = "b";

        printInput("s", "t", new Object[][]{
                {s1, t1}, {s2, t2}, {s3, t3}
        });
        printOutput(
                "backspaceCompare(1)", new e844_BackspaceStringCompare().backspaceCompare(s1, t1),
                "backspaceCompare(2)", new e844_BackspaceStringCompare().backspaceCompare(s2, t2),
                "backspaceCompare(3)", new e844_BackspaceStringCompare().backspaceCompare(s3, t3)
        );
    }
}
