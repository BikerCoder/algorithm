package com.bikercoder.study.algorithm.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author caoguo
 * @Description： 力扣 105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @date：2021/11/1 4:08 下午
 **/
public class BuildTree {
    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree2(preOrder, inOrder);
        List<Integer> list = MyTree.inorderTraversalMorris(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 递归 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param preOrder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preOrder, int[] inorder) {
        int preLength = preOrder.length;
        int inLength = inorder.length;
        // 用HashMap保存中序遍历数组的各个节点的下标
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
        // 构建根节点 前序遍历的首节点为根节点
        TreeNode root = new TreeNode(preOrder[preLeft]);
        // 获取根节点在中序遍历数组中的位置 pIndex
        int pIndex = map.get(root.data);
        // 构建左子树
        root.leftChild = buildTree(preOrder, preLeft + 1, pIndex - inLeft + preLeft, inorder, inLeft, pIndex - 1, map);
        // 构建右子树
        root.rightChild = buildTree(preOrder, pIndex - inLeft + preLeft + 1, preRight, inorder, pIndex + 1, inRight, map);
        return root;
    }

    /**
     * 迭代 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param preOrder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree2(int[] preOrder, int[] inorder) {
        int pre = 0;
        int in = 0;
        TreeNode curRoot = new TreeNode(preOrder[pre++]);
        TreeNode root = curRoot;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(curRoot);
        while (pre < preOrder.length) {
            // 当前节点的值等于中序遍历中的值，说明下一个值的节点为右子节点
            if (curRoot.data == inorder[in]) {
                // 寻找下一个值的节点是谁的右子节点
                // 进行出栈，实现倒序遍历
                while (!stk.isEmpty() && stk.peek().data == inorder[in]) {
                    curRoot = stk.pop();
                    in++;
                }
                curRoot.rightChild = new TreeNode(preOrder[pre++]);
                curRoot = curRoot.rightChild;
                stk.push(curRoot);
            } else {
                // 否则为左子树
                curRoot.leftChild = new TreeNode(preOrder[pre++]);
                curRoot = curRoot.leftChild;
                stk.push(curRoot);
            }
        }

        return root;
    }
}
