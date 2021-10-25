package com.bikercoder.study.algorithm.array;

import com.bikercoder.study.algorithm.tree.MyTree;
import com.bikercoder.study.algorithm.tree.TreeNode;

/**
 * @author caoguo
 * @Description： 108. 将有序数组转换为二叉搜索树 https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @date：2021/10/25 10:51 下午
 **/
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        MyTree.inOrderTraversal(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.leftChild = helper(nums, left, mid - 1);
        root.rightChild = helper(nums, mid + 1, right);
        return root;
    }
}
