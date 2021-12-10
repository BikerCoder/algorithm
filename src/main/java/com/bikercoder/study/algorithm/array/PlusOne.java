package com.bikercoder.study.algorithm.array;

/**
 * @author caoguo
 * @Description： 66. 加一 https://leetcode-cn.com/problems/plus-one/
 * @date：2021/12/10 9:43 下午
 **/
public class PlusOne {

    /**
     * 找出最长的后缀 99
      * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;

    }
}
