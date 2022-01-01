package com.bikercoder.study.algorithm.dynamicProgramming;

/**
 * @author caoguo
 * @Description： 303. 区域和检索 - 数组不可变 https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @date：2022/1/1 2:54 下午
 **/
public class RangeSumQueryImmutable {
    private int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
