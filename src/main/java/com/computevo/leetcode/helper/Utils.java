package com.computevo.leetcode.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
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

    public static void printOutput(String label1, Object output1, String label2, Object output2, String label3, Object output3) {
        printSection("Output", List.of(Pair.of(label1, output1), Pair.of(label2, output2), Pair.of(label3, output3)));
        printFooter();
    }

    public static void printOutput(String label1, Object output1, String label2, Object output2, String label3, Object output3, String label4, Object output4) {
        printSection("Output", List.of(Pair.of(label1, output1), Pair.of(label2, output2), Pair.of(label3, output3), Pair.of(label4, output4)));
        printFooter();
    }

    public static void printInput(Object input) {
        printHeader();
        printSection("Input", List.of(Pair.of(null, input)));
    }

    public static void printInput(String label, Object input) {
        printHeader();
        printSection("Input", List.of(Pair.of(label, input)));
    }

    public static void printInput(String label, Object[] inputs) {
        printHeader();
        List<Pair<String, Object>> labelledInputs = new ArrayList<>();
        for(int i = 0; i < inputs.length; i++) {
            labelledInputs.add(Pair.of(label+(i+1), inputs[i]));
        }
        printSection("Input", labelledInputs);
    }

    public static void printInput(String label1, String label2, Object[][] inputs) {
        printHeader();
        for (int i = 0; i < inputs.length; i++) {
            List<Pair<String, Object>> labelledInputs = new ArrayList<>();
            labelledInputs.add(Pair.of(label1, inputs[i][0]));
            labelledInputs.add(Pair.of(label2, inputs[i][1]));
            printSection("Input"+(i+1), labelledInputs);
        }
    }

    public static void printInput(String label1, Object input1, String label2, Object input2) {
        printHeader();
        printSection("Input", List.of(Pair.of(label1, input1), Pair.of(label2, input2)));
    }

    @SuppressWarnings("unused")
    public static void printInput(String label1, Object input1, String label2, Object input2, String label3, Object input3) {
        printHeader();
        printSection("Input", List.of(Pair.of(label1, input1), Pair.of(label2, input2), Pair.of(label3, input3)));
    }

    @SuppressWarnings("unused")
    public static void printInput(String label1, Object input1, String label2, Object input2, String label3, Object input3, String label4, Object input4) {
        printHeader();
        printSection("Input", List.of(Pair.of(label1, input1), Pair.of(label2, input2), Pair.of(label3, input3), Pair.of(label4, input4)));
    }

    public static void printInput(String label1, Object input1, String label2, Object input2, String label3, Object input3, String label4, Object input4, String label5, Object input5) {
        printHeader();
        printSection("Input", List.of(Pair.of(label1, input1), Pair.of(label2, input2), Pair.of(label3, input3), Pair.of(label4, input4), Pair.of(label5, input5)));
    }

    public static void printInput(String label1, Object input1, String label2, Object input2, String label3, Object input3, String label4, Object input4, String label5, Object input5, String label6, Object input6) {
        printHeader();
        printSection("Input", List.of(Pair.of(label1, input1), Pair.of(label2, input2), Pair.of(label3, input3), Pair.of(label4, input4), Pair.of(label5, input5), Pair.of(label6, input6)));
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
        if (arg.getClass().isAssignableFrom(int[][].class)) {
            return toMatrixString((int[][]) arg);
        }
        if (arg.getClass().isAssignableFrom(char[][].class)) {
            return toMatrixString((char[][]) arg);
        }
        return new ToStringBuilder(arg, ToStringStyle.SIMPLE_STYLE).append(arg).toString();
    }

    private static String toMatrixString(int[][] matrix) {
        StringBuilder sb = new StringBuilder("\n");
        for (int row = 0; row < matrix.length; row++) {
            if (row == 0)
                sb.append("┌");
            else if (row == matrix.length - 1)
                sb.append("└");
            else sb.append("│");

            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(String.format("%3d", matrix[row][col]));
            }
            sb.append("  ");
            if (row == 0)
                sb.append("┐");
            else if (row == matrix.length - 1)
                sb.append("┘");
            else sb.append("│");
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String toMatrixString(char[][] matrix) {
        StringBuilder sb = new StringBuilder("\n");
        for (int row = 0; row < matrix.length; row++) {
            if (row == 0)
                sb.append("┌");
            else if (row == matrix.length - 1)
                sb.append("└");
            else sb.append("│");

            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(String.format(" %s ", matrix[row][col]));
            }
            sb.append(" ");
            if (row == 0)
                sb.append("┐");
            else if (row == matrix.length - 1)
                sb.append("┘");
            else sb.append("│");
            sb.append("\n");
        }
        return sb.toString();
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
        return nodes.size() > 0 ? nodes.get(0) : new ListNode(-1);
    }
}
