package com.bikercoder.study.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author caoguo
 * @Description： 435. 无重叠区间 https://leetcode-cn.com/problems/non-overlapping-intervals/
 * @date：2021/12/14 8:53 下午
 **/
public class EraseOverlapIntervals {

    /**
     * 排序 + 贪心 时间复杂度O(nlogn) 空间复杂度O(logn)
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
