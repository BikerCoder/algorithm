package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 62. 不同路径 https://leetcode-cn.com/problems/unique-paths/
 * @date：2021/12/31 2:42 下午
 **/
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    /**
     * 动态规划 时间复杂度O(mn) 空间复杂度O(mn)
     * if i > 0 j == 0 时，dp[i][0] = 1
     * if i == 0 j > 0 时，dp[0][j] = 1
     * if i > 0 j > 0 时，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if (m == 1) return 1;
        if (n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
