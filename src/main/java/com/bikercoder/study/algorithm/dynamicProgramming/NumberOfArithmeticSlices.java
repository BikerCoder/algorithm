package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 413. 等差数列划分 https://leetcode-cn.com/problems/arithmetic-slices/
 * @date：2022/1/4 9:24 下午
 **/
public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    /**
     * 动态规划 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int ans = 0, t = 0, d = nums[0] - nums[1];
        for (int i = 2; i < n; i++) {
            if (nums[i - 1] - nums[i] == d) {
                t++;
            } else {
                t = 0;
                d = nums[i - 1] - nums[i];
            }
            ans += t;
        }
        return ans;
    }
}
