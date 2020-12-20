package com.bikercoder.study.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author caoguo
 * @Description： 《小灰的算法之旅》二叉树
 * @date：12/17/20 10:53 PM
 **/
public class MyTree {

    private static class TreeNode{
        Integer data; // 数据
        TreeNode leftChild; // 左子节点
        TreeNode rightChild; // 右子节点
        TreeNode(Integer data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,
                null,8,null,4}));
        TreeNode node = createTree(inputList);
        System.out.println("前序遍历");
        preOrderTraversal(node);
        System.out.println("中序遍历");
        inOrderTraversal(node);
        System.out.println("后序遍历");
        postOrderTraversal(node);
    }

    /**
     * 前序遍历
     * @param node 树的根节点
     */
    private static void preOrderTraversal(TreeNode node) {
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 构建二叉树
     * @param inputList
     * @return
     */
    private static TreeNode createTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createTree(inputList);
            node.rightChild = createTree(inputList);
        }
        return node;

    }
}
