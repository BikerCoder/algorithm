package com.bikercoder.study.algorithm.tree;

import java.util.*;

/**
 * @author caoguo
 * @Description： 力扣 102. 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @date：2021/10/31 11:54 上午
 **/
public class LevelOrder {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{2, 5, 7, null, 3, null, null, 4, null,
                null, 5, 4, null, null, 7, 3, null}));
        TreeNode tree = MyTree.createTree(inputList);
        List<List<Integer>> lists = leveOrder(tree);
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
    public static List<List<Integer>> leveOrder(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                root = queue.poll();
                list.add(root.data);
                if (root.leftChild != null) {
                    queue.offer(root.leftChild);
                }
                if (root.rightChild != null) {
                    queue.offer(root.rightChild);
                }
                size--;
            }
            re.add(list);
        }

        return re;
    }
}
