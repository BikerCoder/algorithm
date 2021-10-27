package com.bikercoder.study.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caoguo
 * @Description： 350. 两个数组的交集 II https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @date：2021/10/26 8:47 下午
 **/
public class Intersect {
    public static void main(String[] args) {
        int[] num1 = new int[]{2, 4, 5, 4, 9};
        int[] num2 = new int[]{1, 4, 9, 7, 9};
        int[] intersect = intersect2(num1, num2);
        System.out.println(Arrays.toString(intersect));

    }

    /**
     * 采用HashMap存储数组1中每个数字出现的个数，再遍历数组2，存在这放入结果数组中，并且map中个数减1
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] re = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                re[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(re, 0, index);
    }

    /**
     * 排序+双指针 时间复杂度 对两个数组进行排序的时间复杂度是 O(mlogm+nlogn)，
     * 遍历两个数组的时间复杂度是 O(m+n)，因此总时间复杂度是 O(mlogm+nlogn)
     * 空间复杂度O(min(m,n))
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index = 0, index1 = 0, index2 = 0;
        int[] re = new int[Math.min(length1, length2)];
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] == nums2[index2]) {
                re[index++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOfRange(re, 0, index);
    }

}
