package com.computevo.leetcode.leetcode75.lvl1;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/?envType=study-plan&id=level-1">link</a>
 */
public class m200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        return islandCount;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (grid[row][col] != '1')
            return;
        grid[row][col] = '0';
        if (row > 0) dfs(grid, row - 1, col);
        if (row + 1 < grid.length) dfs(grid, row + 1, col);
        if (col > 0) dfs(grid, row, col - 1);
        if (col + 1 < grid[row].length) dfs(grid, row, col + 1);
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        printInput("grid 1", grid, "grid 2", grid2);
        printOutput(
                "grid 1", new m200_NumberOfIslands().numIslands(grid),
                "grid 2", new m200_NumberOfIslands().numIslands(grid2)
        );
    }
}
