package com.bikercoder.study.algorithm.array;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 力扣 88.合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 * @date：2021/10/13 5:08 下午
 **/
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge2(nums1, 3, nums2, 3);
    }

    /**
     * 双指针 时间复杂度O(m+n) 空间复杂度O(m+n)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int cur;
        int[] sort = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sort[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sort[i];
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 逆向双指针 时间复杂度O(m+n) 空间复杂度O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] >= nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
        System.out.println(Arrays.toString(nums1));
    }

}
