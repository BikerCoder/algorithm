package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 300. 最长递增子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @date：2022/1/7 10:02 下午
 **/
public class LengthOfLIS {

    /**
     * 动态规划 时间复杂度O(n平方) 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
