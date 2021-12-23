package com.bikercoder.study.algorithm.binarySearch;

/**
 * @author caoguo
 * @Description： 744. 寻找比目标字母大的最小字母 https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * @date：2021/12/23 9:55 下午
 **/
public class NextGreatestLetter {

    /**
     * 二分 时间复杂度O(log n) 空间复杂度O(1)
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left % letters.length];
    }
}
