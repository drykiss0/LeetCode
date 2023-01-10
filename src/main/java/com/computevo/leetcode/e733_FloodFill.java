package com.computevo.leetcode;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/flood-fill/?envType=study-plan&id=level-1">link</a>
 */
public class e733_FloodFill {

    public int[][] floodFill(int[][] image, int row, int col, int color) {
        int fromColor = image[row][col];
        if (fromColor != color)
            floodFill(image, row, col, fromColor, color);
        return image;
    }

    private void floodFill(int[][] image, int row, int col, int fromColor, int toColor) {

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != fromColor)
            return;

        image[row][col] = toColor;
        floodFill(image, row - 1, col, fromColor, toColor);
        floodFill(image, row + 1, col, fromColor, toColor);
        floodFill(image, row, col - 1, fromColor, toColor);
        floodFill(image, row, col + 1, fromColor, toColor);
    }

    public static void main(String[] args) {

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int row = 1;
        int col = 1;
        int color = 2;

        printInput("Image", image, "s-row", row, "s-col", col, "color", color);
        int[][] result = new e733_FloodFill().floodFill(image, row, col, color);

        printOutput(result);
    }
}
