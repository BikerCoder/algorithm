package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 64. 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum/
 * @date：2021/12/30 9:34 下午
 **/
public class MinPathSum {

    /**
     * 动态规划 时间复杂度O(mn) 空间复杂度O(mn)
     * 当i > 0, j = 0时, dp[i][0] = dp[i - 1][0] + grid[i][0]
     * 当i = 0, j > 0时, dp[0][j] = dp[0][j - 1] + grid[0][j]
     * 当i > 0, j > 0时, dp[i][j] = min(dp[i - 1][j], dp[i][j - 1] ) + grid[i][0]
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, colums = grid[0].length;
        int[][] dp = new int[rows][colums];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < colums; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < colums; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][colums - 1];


    }
}
