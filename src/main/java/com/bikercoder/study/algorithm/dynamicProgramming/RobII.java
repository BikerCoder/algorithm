package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 213. 打家劫舍 II https://leetcode-cn.com/problems/house-robber-ii/
 * @date：2021/12/29 8:32 下午
 **/
public class RobII {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 3, 1, 3, 100}));
    }

    /**
     * 动态规划 时间复杂度O(n) 空间复杂度O(1)
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
        } else if (length == 2) {
            return nums[1];
        }
        return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length - 1));
    }

    public static int rob(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int cur = Math.max(first + nums[i], second);
            first = second;
            second = cur;
        }
        return second;

    }
}
