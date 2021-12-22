package com.bikercoder.study.algorithm.array;

/**
 * @author caoguo
 * @Description： 665. 非递减数列 https://leetcode-cn.com/problems/non-decreasing-array/
 * @date：2021/12/22 9:32 下午
 **/
public class CheckPossibility {

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
