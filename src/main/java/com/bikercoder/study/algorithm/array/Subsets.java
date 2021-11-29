package com.bikercoder.study.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoguo
 * @Description： 78. 子集 https://leetcode-cn.com/problems/subsets/
 * @date：2021/11/29 10:04 下午
 **/
public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> subset = subset(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(subset.stream().toArray()));
    }

    /**
     * 递归 时间复杂度O(n×2的n次方) 空间复杂度O(n×2的n次方)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : res) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            res.addAll(newSubsets);
        }
        return res;
    }
}
