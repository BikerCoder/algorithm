package com.bikercoder.study.algorithm.binarySearch;

/**
 * @author caoguo
 * @Description： 278. 第一个错误的版本 https://leetcode-cn.com/problems/first-bad-version/
 * @date：2021/12/25 10:38 下午
 **/
public class FirstBadVersion {

    /**
     * 二分法 时间复杂度O(logn) 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean isBadVersion(int version) {
        return true;
    }
}
