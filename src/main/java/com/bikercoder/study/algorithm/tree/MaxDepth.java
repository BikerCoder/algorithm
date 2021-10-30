package com.bikercoder.study.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author caoguo
 * @Description： 力扣 104. 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @date：2021/10/29 12:56 下午
 **/
public class MaxDepth {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{2, 5, 7, null, 3, null, null, 4, null,
                null, 5, 4, null, null, 7, 3, null}));
        TreeNode tree = MyTree.createTree(inputList);
        System.out.println(maxDepth2(tree));
    }

    /**
     * 递归 深度优先搜索 时间复杂度O(n)  空间复杂度O(depth)
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rigthDepth = maxDepth(root.rightChild);
        int leftDepth = maxDepth(root.leftChild);
        return Math.max(rigthDepth, leftDepth) + 1;
    }

    /**
     * 迭代 广度优先搜索 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.leftChild != null) {
                    queue.offer(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.offer(node.rightChild);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
