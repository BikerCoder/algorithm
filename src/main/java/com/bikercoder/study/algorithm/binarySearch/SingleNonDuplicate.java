package com.bikercoder.study.algorithm.binarySearch;

/**
 * @author caoguo
 * @Description： 540. 有序数组中的单一元素 https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @date：2021/12/24 9:27 下午
 **/
public class SingleNonDuplicate {

    /**
     * 二分 时间复杂度O(logn) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
