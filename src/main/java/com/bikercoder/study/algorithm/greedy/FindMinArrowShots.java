package com.bikercoder.study.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author caoguo
 * @Description： 452. 用最少数量的箭引爆气球 https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @date：2021/12/15 9:23 下午
 **/
public class FindMinArrowShots {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    /**
     * 排序 + 贪心
     * 时间复杂度O(nlogn) 其中n是数组points的长度,排序的时间复杂度为O(nlogn)。对气球遍历的时间复杂度为O(n),其在渐进意义下小于前者，则忽略不计
     * 空间复杂度O(logn) 排序需要的栈空间
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int point = points[0][1];
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > point) {
                ans++;
                point = points[i][1];
            }
        }
        return ans;
    }
}
