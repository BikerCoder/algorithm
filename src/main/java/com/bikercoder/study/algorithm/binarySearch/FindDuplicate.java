package com.bikercoder.study.algorithm.binarySearch;

/**
 * @author caoguo
 * @Description： 287. 寻找重复数 https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @date：2021/12/4 11:47 上午
 **/
public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 2, 3, 3, 4}));
    }

    /**
     * 二分法
     * 时间复杂度O(nlogn) n为数组的长度，二分查找最多需要二分O(logn)次 每次判断的时候需要O(n)遍历nums数组求解小于等于mid的个数
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
