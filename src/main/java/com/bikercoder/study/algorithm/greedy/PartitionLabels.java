package com.bikercoder.study.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoguo
 * @Description： 763. 划分字母区间 https://leetcode-cn.com/problems/partition-labels/
 * @date：2021/12/21 5:27 下午
 **/
public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     * 贪心
     * 时间复杂度O(n)
     * 空间复杂度O(∣Σ∣)，其中 Σ 是字符串中的字符集, Σ = 26
     *
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (end == i) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }

        return partition;
    }
}
