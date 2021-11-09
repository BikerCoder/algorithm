package com.bikercoder.study.algorithm.string;

/**
 * @author caoguo
 * @Description： 125. 验证回文串 https://leetcode-cn.com/problems/valid-palindrome/
 * @date：2021/11/8 8:47 下午
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 双指针 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (Character.toUpperCase(chars[left]) != Character.toUpperCase(chars[right])) {
                if (!Character.isLetterOrDigit(chars[left])) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(chars[right])) {
                    right--;
                    continue;
                }
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
