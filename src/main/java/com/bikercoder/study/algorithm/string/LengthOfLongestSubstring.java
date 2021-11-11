package com.bikercoder.study.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 3. 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @date：2021/11/10 4:58 下午
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 滑动窗口
     * 时间复杂度O(n) n表示字符串长度
     * 空间复杂度O(m) m表示字符集大小
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int re = 0;
        int right = -1;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(++right));
            }
            re = Math.max(re, right - i + 1);
        }
        return re;
    }
}
