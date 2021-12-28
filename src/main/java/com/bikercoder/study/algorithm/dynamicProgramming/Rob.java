package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 198. 打家劫舍 https://leetcode-cn.com/problems/house-robber/
 * @date：2021/12/28 10:13 下午
 **/
public class Rob {

    /**
     * 动态规划 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return dp[length - 1];
    }
}
