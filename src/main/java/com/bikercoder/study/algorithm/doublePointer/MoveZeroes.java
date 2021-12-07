package com.bikercoder.study.algorithm.doublePointer;

/**
 * @author caoguo
 * @Description： 283. 移动零  https://leetcode-cn.com/problems/move-zeroes/
 * @date：2021/12/7 9:03 下午
 **/
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, right, left);
                left++;
            }
            right++;
        }
    }

    private static void swap(int[] nums, int right, int left) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
