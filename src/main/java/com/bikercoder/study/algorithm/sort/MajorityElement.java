package com.bikercoder.study.algorithm.sort;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 169. 多数元素 https://leetcode-cn.com/problems/majority-element/
 * @date：2021/12/9 10:29 下午
 **/
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
