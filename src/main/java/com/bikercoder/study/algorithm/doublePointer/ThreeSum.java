package com.bikercoder.study.algorithm.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoguo
 * @Description： 15. 三数之和 https://leetcode-cn.com/problems/3sum/
 * @date：2021/12/8 10:29 下午
 **/
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());

    }

    /**
     * 排序 + 双指针 时间复杂度O(N^2)  空间复杂度O(logn)
     * <p>
     * 简单一句话，先固定第一个数a，然后b、c只能从两边向中间靠（在a之后）。细节条件就是去重处理
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int thrid = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < thrid; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < thrid && nums[second] + nums[thrid] > target) {
                    thrid--;
                }
                if (second == thrid) {
                    break;
                }
                if (nums[first] + nums[second] + nums[thrid] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[thrid]);
                    ans.add(res);
                }
            }
        }
        return ans;
    }
}
