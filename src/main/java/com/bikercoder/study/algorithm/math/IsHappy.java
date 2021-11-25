package com.bikercoder.study.algorithm.math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 202. 快乐数 https://leetcode-cn.com/problems/happy-number/
 * @date：2021/11/25 10:50 下午
 **/
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    /**
     * 用哈希来检测循环 时间复杂度O(logn) 空间复杂度O(logn)
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            total += d * d;
        }
        return total;
    }
}
