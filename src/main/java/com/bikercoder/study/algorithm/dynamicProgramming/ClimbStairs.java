package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 70. 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
 * @date：2021/12/27 9:31 下午
 **/
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(6));
    }

    /**
     * 动态规划 - 滚动数组 时间复杂度O(n) 空间复杂度O(1)
     * f(n) = f(n-1) + f(n - 2)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int dp1 = 1, dp2 = 2;
        for (int i = 2; i < n; i++) {
            int cur = dp1 + dp2;
            dp1 = dp2;
            dp2 = cur;
        }

        return dp2;
    }

    /**
     * 动态规划 时间复杂度O(n) 空间复杂度O(n)
     * f(n) = f(n-1) + f(n - 2)
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
