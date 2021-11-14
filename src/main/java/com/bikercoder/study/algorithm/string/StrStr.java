package com.bikercoder.study.algorithm.string;

/**
 * @author caoguo
 * @Description： 28. 实现 strStr() https://leetcode-cn.com/problems/implement-strstr/
 * @date：2021/11/14 8:43 下午
 **/
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }

    /**
     * 爆破 时间复杂度O(m * n) 空间复杂度O(1)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
