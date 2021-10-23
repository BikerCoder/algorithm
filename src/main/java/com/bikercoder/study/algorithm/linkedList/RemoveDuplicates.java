package com.bikercoder.study.algorithm.linkedList;

/**
 * @author caoguo
 * @Description： 力扣26. 删除有序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @date：2021/10/23 4:58 下午
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 快慢指针 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 1;
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        while (fast < length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
