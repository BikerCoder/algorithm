package com.bikercoder.study.algorithm.string;

/**
 * @author caoguo
 * @Description： 14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 * @date：2021/11/4 10:18 下午
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = new String[]{"lon","lo","long"};
        String[] strs = new String[]{"lon", "lo", "ong"};
        System.out.println(longestCommonPrefix(strs));
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
}
