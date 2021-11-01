package com.bikercoder.study.algorithm.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caoguo
 * @Description： 力扣 105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @date：2021/11/1 4:08 下午
 **/
public class BuildTree {
    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree(preOrder, inOrder);
        List<Integer> list = MyTree.inorderTraversalMorris(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 递归
     * @param preOrder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preOrder, int[] inorder) {
        int preLength = preOrder.length;
        int inLength = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preOrder, 0, preLength - 1, inorder, 0, inLength - 1, map);
    }

    public static TreeNode buildTree(int[] preOrder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight,
                                     Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int pIndex = map.get(root.data);
        root.leftChild = buildTree(preOrder, preLeft + 1, pIndex - inLeft + preLeft, inorder, inLeft, pIndex - 1, map);
        root.rightChild = buildTree(preOrder, pIndex - inLeft + preLeft + 1, preRight, inorder, pIndex + 1, inRight, map);
        return root;
    }
}
