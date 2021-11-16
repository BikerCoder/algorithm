package com.bikercoder.study.algorithm.array;

/**
 * @author caoguo
 * @Description： 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @date：2021/11/16 9:24 下午
 **/
public class MaxProfitII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 贪心算法 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }
}
