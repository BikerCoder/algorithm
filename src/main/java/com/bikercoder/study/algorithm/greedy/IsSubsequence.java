package com.bikercoder.study.algorithm.greedy;

/**
 * @author caoguo
 * @Description： 392. 判断子序列 https://leetcode-cn.com/problems/is-subsequence/
 * @date：2021/12/18 10:38 下午
 **/
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
