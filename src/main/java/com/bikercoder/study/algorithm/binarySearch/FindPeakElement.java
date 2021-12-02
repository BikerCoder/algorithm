package com.bikercoder.study.algorithm.binarySearch;

/**
 * @author caoguo
 * @Description： 162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
 * @date：2021/12/2 10:40 下午
 **/
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 2}));
    }

    /**
     * 迭代爬坡 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {

        int n = nums.length;
        int idx = (int) Math.random() * n;
        while (!(compare(nums, idx - 1, idx) < 0 && compare(nums, idx, idx + 1) > 0)) {
            if (compare(nums, idx, idx + 1) > 0) {
                idx -= 1;
            } else {
                idx += 1;
            }
        }
        return idx;
    }

    private static int compare(int[] nums, int idx1, int idx2) {
        int[] nums1 = get(nums, idx1);
        int[] nums2 = get(nums, idx2);
        if (nums1[0] != nums2[0]) {
            return nums1[0] > nums2[0] ? 1 : -1;
        }
        if (nums1[1] == nums2[1]) {
            return 0;
        }
        return nums1[1] > nums2[1] ? 1 : -1;

    }

    private static int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }
}
