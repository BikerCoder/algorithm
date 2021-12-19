package com.bikercoder.study.algorithm.greedy;

/**
 * @author caoguo
 * @Description： 53. 最大子数组和 https://leetcode-cn.com/problems/maximum-subarray/
 * @date：2021/12/19 10:34 下午
 **/
public class MaxSubArray {

    /**
     * 贪心 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
}
