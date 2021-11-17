package com.bikercoder.study.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 128. 最长连续序列 https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @date：2021/11/17 10:07 下午
 **/
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    /**
     * 哈希 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        int longestStreak = 0;
        for (Integer num : sets) {
            if (!sets.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (sets.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
