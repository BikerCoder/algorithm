package com.bikercoder.study.algorithm.greedy;

/**
 * @author caoguo
 * @Description： 605. 种花问题 https://leetcode-cn.com/problems/can-place-flowers/
 * @date：2021/12/17 10:38 下午
 **/
public class CanPlaceFlowers {


    /**
     * 贪心
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) {
                    return true;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }
}
