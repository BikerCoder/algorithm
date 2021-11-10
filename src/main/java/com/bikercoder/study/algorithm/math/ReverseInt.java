package com.bikercoder.study.algorithm.math;

/**
 * @author caoguo
 * @Description： 7. 整数反转 https://leetcode-cn.com/problems/reverse-integer/
 * @date：2021/11/10 8:06 下午
 **/
public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(463847412));
    }

    /**
     * 时间复杂度：O(log∣x∣)。翻转的次数即 xx 十进制的位数
     * 空间复杂度 O(1)
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int re = 0;
        while (x != 0) {
            if (re > Integer.MAX_VALUE / 10 || re < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int y = x % 10;
            x /= 10;
            re = re * 10 + y;
        }
        return re;
    }
}
