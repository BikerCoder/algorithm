package com.bikercoder.study.algorithm.math;

/**
 * @author caoguo
 * @Description： 69. Sqrt(x) https://leetcode-cn.com/problems/sqrtx/
 * @date：2021/12/1 10:03 下午
 **/
public class MySqrt {

    /**
     * 二分法 时间复杂度O(logx) 空间复杂度 O(1)
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }
        if (ans * ans <= x) {
            return ans;
        }
        return ans - 1;

    }
}
