package com.bikercoder.study.algorithm.doublePointer;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 75. 颜色分类 https://leetcode-cn.com/problems/sort-colors/
 * @date：2021/12/6 9:17 下午
 **/
public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }
        }
    }
}

