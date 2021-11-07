package com.bikercoder.study.algorithm.string;

/**
 * @author caoguo
 * @Description： 344. 反转字符串 https://leetcode-cn.com/problems/reverse-string/
 * @date：2021/11/7 9:16 下午
 **/
public class ReverseString {
    public static void main(String[] args) {
        char[] chars = "left".toCharArray();
        reverseString(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }

    /**
     * 双指针 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }
}
