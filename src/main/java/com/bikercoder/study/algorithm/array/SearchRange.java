package com.bikercoder.study.algorithm.array;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 力扣 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @date：2021/10/24 10:12 下午
 **/
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        nums = searchRange(nums, 7);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = binarySearchLeft(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = binarySearchRight(nums, target);
        return new int[]{left, right};
    }

    private static int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int binarySearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
