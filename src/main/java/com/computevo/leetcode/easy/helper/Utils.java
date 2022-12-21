package com.computevo.leetcode.easy.helper;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;

public class Utils {

    public static void printSolution(Object input, Object output) {
        System.out.println("\n------- " + callerName() + " -------\n");
        System.out.println("Input  = " + toSmartString(input));
        System.out.println("Output = " + toSmartString(output));
        System.out.println("\n--------------");
    }

    public static void printSolution(Object[][] namedInputs, Object output) {
        System.out.println("\n------- " + callerName() + " -------\n");
        StringBuilder namedInputString = new StringBuilder("{");
        Arrays.stream(namedInputs).forEach(namedInput ->
                namedInputString.append(
                        String.format(" \"%s\" = %s",
                                toSmartString(namedInput[0]),
                                toSmartString(namedInput[1])))
        );
        namedInputString.append(" }");
        System.out.println("Input  = " + namedInputString);
        System.out.println("Output = " + toSmartString(output));
        System.out.println("\n--------------");
    }

    private static String toSmartString(Object arg) {
        ToStringBuilder builder = new ToStringBuilder(arg, ToStringStyle.SIMPLE_STYLE);
        return builder
                .append(arg).toString();
    }

    private static String callerName() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        String fullClassName = stacktrace[stacktrace.length - 1].getClassName();
        return fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
    }
}
