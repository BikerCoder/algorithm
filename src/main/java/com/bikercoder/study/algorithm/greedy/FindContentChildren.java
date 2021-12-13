package com.bikercoder.study.algorithm.greedy;

import java.util.Arrays;

/**
 * @author caoguo
 * @Description： 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 * @date：2021/12/13 9:46 下午
 **/
public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2}));
    }

    /**
     * 排序 + 贪心
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;

    }
}
