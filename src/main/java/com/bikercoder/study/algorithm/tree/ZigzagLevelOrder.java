package com.bikercoder.study.algorithm.tree;

import java.util.*;

/**
 * @author caoguo
 * @Description： 力扣 103. 二叉树的锯齿形层序遍历 https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @date：2021/10/31 2:15 下午
 **/
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{2, 3, 7, null, 3, null, null, 4, null,
                null, 5, 4, null, null, 8, 5, null}));
        TreeNode tree = MyTree.createTree(inputList);
        List<List<Integer>> lists = zigzagLevelOrder(tree);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 广度优先搜索 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftOrder = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                root = queue.poll();
                if (isLeftOrder) {
                    levelList.offer(root.data);
                } else {
                    levelList.offerFirst(root.data);
                }
                if (root.leftChild != null) {
                    queue.offer(root.leftChild);
                }
                if (root.rightChild != null) {
                    queue.offer(root.rightChild);
                }
                size--;
            }
            ans.add(new LinkedList<Integer>(levelList));
            isLeftOrder = !isLeftOrder;
        }
        return ans;
    }
}
