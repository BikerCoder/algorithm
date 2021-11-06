package com.bikercoder.study.algorithm.string;

/**
 * @author caoguo
 * @Description： 14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 * @date：2021/11/4 10:18 下午
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"lon", "lo", "long"};
        System.out.println(longestCommonPrefix3(strs));
    }

    /**
     * 横向扫描
     * 时间复杂度O(mn) m是字符串数组中字符串的平均长度 n是数组的长度
     * 空间复杂度O(1)
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        String prefix = strs[0];
        for (int i = 0; i < length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix == "") {
                return "";
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix(String prefix, String str) {
        int length = Math.min(prefix.length(), str.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == str.charAt(index)) {
            index++;
        }
        return prefix.substring(0, index);
    }

    /**
     * 竖向扫描 m是字符串数组中字符串的平均长度 n是数组的长度
     * 时间复杂度O(mn)
     * 空间复杂度O(1)
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < count; j++) {
                if (strs[j].length() == i || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 分治法
     * 时间复杂度O(mn) m是字符串数组中字符串的平均长度 n是数组的长度
     * 空间复杂度O(m logn) 其中m是字符串数组中的字符串的平均长度，n是字符串的数量。
     * 空间复杂度主要取决于递归调用的层数，层数最大为logn，每层需要m的空间存储返回结果
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        return longestCommonPrefix3(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix3(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) >> 1;
        String leftStr = longestCommonPrefix3(strs, left, mid);
        String rightStr = longestCommonPrefix3(strs, mid + 1, right);
        return commonPrefix(leftStr, rightStr);
    }

    private static String commonPrefix(String leftStr, String rightStr) {
        int length = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < length; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, length);
    }
}
