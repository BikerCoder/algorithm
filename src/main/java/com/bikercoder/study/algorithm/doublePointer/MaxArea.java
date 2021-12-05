package com.bikercoder.study.algorithm.doublePointer;

/**
 * @author caoguo
 * @Description： 11. 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
 * @date：2021/12/5 9:27 下午
 **/
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{10, 14, 10, 4, 10, 2, 6, 1, 6, 12}));
    }

    /**
     * 双指针 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
