package com.bikercoder.study.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 268. 丢失的数字 https://leetcode-cn.com/problems/missing-number/
 * @date：2021/11/30 11:06 下午
 **/
public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3}));
    }

    /**
     * 哈希 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add((nums[i]));
        }

        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }
}
