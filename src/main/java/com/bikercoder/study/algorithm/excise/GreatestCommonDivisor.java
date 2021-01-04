package com.bikercoder.study.algorithm.excise;

/**
 * @author caoguo
 * @Description： 最大公约数
 * @date：1/4/21 10:50 PM
 **/
public class GreatestCommonDivisor {
    /**
     * 辗转相除法
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor(int a, int b){
        int big = a > b ? a : b;
        int small = a > b ? b : a;
        int c = big % small;
        if(c == 0) {
            return small;
        }
        return getGreatestCommonDivisor(small, c);

    }

    /**
     * 更相减损术
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV3(int a, int b){
        if(a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a > b ? b : a;
        return getGreatestCommonDivisor(small,big - small);

    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisorV3(100,80));
    }
}
