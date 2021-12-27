package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 70. 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
 * @date：2021/12/27 9:31 下午
 **/
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    /**
     * 动态规划 时间复杂度O(n) 空间复杂度O(1)
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
}
