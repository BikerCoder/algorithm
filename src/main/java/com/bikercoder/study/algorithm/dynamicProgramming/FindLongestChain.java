package com.bikercoder.study.algorithm.dynamicProgramming;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 646. 最长数对链 https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
 * @date：2022/1/8 3:37 下午
 **/
public class FindLongestChain {

    /**
     * 动态规划 时间复杂度O(n平方) 空间复杂度O(n)
     *
     * @param pairs
     * @return
     */
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
