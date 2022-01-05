package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 343. 整数拆分 https://leetcode-cn.com/problems/integer-break/
 * @date：2022/1/5 9:00 下午
 **/
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    /**
     * 动态规划 时间复杂度O(n的平方) 空间复杂度O(n)
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
