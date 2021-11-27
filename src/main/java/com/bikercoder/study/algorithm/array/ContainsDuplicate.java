package com.bikercoder.study.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 217. 存在重复元素 https://leetcode-cn.com/problems/contains-duplicate/
 * @date：2021/11/27 11:11 下午
 **/
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,1,3}));
    }

    /**
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
