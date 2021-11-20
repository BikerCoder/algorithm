package com.bikercoder.study.algorithm.array;

/**
 * @author caoguo
 * @Description： 136. 只出现一次的数字 https://leetcode-cn.com/problems/single-number/
 * @date：2021/11/20 9:10 下午
 **/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 4, 1, 1}));
    }

    /**
     * 异或 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
