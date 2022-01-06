package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 279. 完全平方数 https://leetcode-cn.com/problems/perfect-squares/
 * @date：2022/1/6 9:05 下午
 **/
public class NumSquares {


    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minm = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minm = Math.min(minm, dp[i - j * j]);
            }
            dp[i] = minm + 1;
        }
        return dp[n];
    }
}
