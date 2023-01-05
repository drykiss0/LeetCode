package com.computevo.leetcode.easy.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static final String DELIM = ", ";

    @SuppressWarnings("unused")
    public static void printDebug(Object obj) {
        System.out.printf("  --> %s%n", toSmartString(obj));
    }

    public static void printSolution(Object input, Object output) {
        printInput(input);
        printOutput(output);
    }

    public static void printOutput(Object output) {
        printOutput(null, output);
    }

    public static void printOutput(String label, Object output) {
        printSection("Output", List.of(Pair.of(label, output)));
        printFooter();
    }

    public static void printOutput(String label1, Object output1, String label2, Object output2) {
        printSection("Output", List.of(Pair.of(label1, output1), Pair.of(label2, output2)));
        printFooter();
    }

    public static void printInput(Object input) {
        printHeader();
        printSection("Input", List.of(Pair.of(null, input)));
    }

    public static void printInput(String label1, Object input1, String label2, Object input2) {
        printHeader();
        printSection("Input", List.of(Pair.of(label1, input1), Pair.of(label2, input2)));
    }

    @SuppressWarnings("unused")
    public static void printInput(String label1, Object input1, String label2, Object input2, String label3, Object input3) {
        printHeader();
        printSection("Input", List.of(Pair.of(label1, input1), Pair.of(label2, input2),  Pair.of(label3, input3)));
    }

    private static void printSection(String sectionLabel, List<Pair<String, Object>> dataList) {
        String namedInputString = dataList.stream().map(data -> {
            StringBuilder sb = new StringBuilder(" ");
            if (StringUtils.isNotBlank(data.getLeft())) {
                sb.append(String.format("%s = ", data.getLeft()));
            }
            return sb.append(String.format("%s\n", toSmartString(data.getRight()))).toString();
        }).collect(Collectors.joining());
        System.out.printf("%s:\n%s", sectionLabel, namedInputString);
    }

    private static String header() {
        return "---------- " +
                callerName()
                        .replaceAll("_", "")
                        .replaceAll("([A-Z])", " $1") +
                " ----------";
    }

    private static void printHeader() {
        System.out.println("\n" + header());
    }

    private static void printFooter() {
        System.out.println(StringUtils.repeat('-', header().length()));
    }

    private static String toSmartString(Object arg) {
        try {
            if (arg == null || arg.getClass().getMethod("toString").getDeclaringClass().equals(arg.getClass())) {
                return String.valueOf(arg);
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return new ToStringBuilder(arg, ToStringStyle.SIMPLE_STYLE).append(arg).toString();
    }

    private static String callerName() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        String fullClassName = stacktrace[stacktrace.length - 1].getClassName();
        return fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
    }

    public static ListNode parseListNodes(String input) {
        List<ListNode> nodes = Arrays.stream(input
                        .replaceAll("[\\[\\]\\s]", "")
                        .split(","))
                .filter(s -> !s.isBlank())
                .map(s -> new ListNode(Integer.parseInt(s)))
                .toList();
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return nodes.size() > 0 ? nodes.get(0) : null;
    }
}
