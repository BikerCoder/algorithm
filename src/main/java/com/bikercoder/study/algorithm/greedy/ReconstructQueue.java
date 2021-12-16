package com.bikercoder.study.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author caoguo
 * @Description： 406. 根据身高重建队列 https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @date：2021/12/16 10:19 下午
 **/
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] ans = reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }

    /**
     * 从高到低考虑
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(log n)
     *
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
