package com.bikercoder.study.algorithm.tree;

import java.util.*;

/**
 * @author caoguo
 * @Description： 《小灰的算法之旅》二叉树
 * @date：12/17/20 10:53 PM
 **/
public class MyTree {

    private static class TreeNode {
        Integer data; // 数据
        TreeNode leftChild; // 左子节点
        TreeNode rightChild; // 右子节点

        TreeNode(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null,
                null, 8, null, 4}));
        TreeNode node = createTree(inputList);
        System.out.println("前序遍历");
        preOrderTraversal(node);
        System.out.println("中序遍历");
        inOrderTraversal(node);
        List<Integer> integers = inorderTraversalMorris(node);
        System.out.println("后序遍历");
        postOrderTraversal(node);
        System.out.println("借助栈来进行前序遍历");
        preOrderTraveralWithStack(node);
        System.out.println("借助栈来进行中序遍历");
        inOrderTraversalWithStack(node);
        System.out.println("借助栈来进行后序遍历");
        postOrderTraversalWithStack(node);
        System.out.println("层序遍历");
        levelOrderTraversal(node);
    }

    /**
     * 莫里斯中序遍历，最终会将二叉树转换成一个链表，由左往右遍历
     *
     *              3                       2                           9
     *            /   \                    / \                           \
     *           2     8     --->        9   10         ---->             2
     *          / \      \                     \                           \
     *         9   10     4                     3                           10
     *                                           \                           \
     *                                            8                           3
     *                                             \                           \
     *                                              4                           8
     *                                                                           \
     * @param root                                                                4
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode pred = new TreeNode(0);
        while (root != null) {
            if (root.leftChild != null) {
                pred = root.leftChild;
                while (pred.rightChild != null) {
                    pred = pred.rightChild;
                }

                pred.rightChild = root;
                TreeNode tmp = root;
                root = root.leftChild;
                tmp.leftChild = null;
            } else {
                res.add(root.data);
                root = root.rightChild;
            }
        }
        return res;
    }

    /**
     * 中序遍历-莫里斯遍历，这种方法不会破坏数结构
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode pred = new TreeNode(0);
        while (root != null) {
            if(root.leftChild != null) {
                // 找到pred
                pred = root.leftChild;
                while(pred.rightChild != null && pred.rightChild != root) {
                    pred = pred.rightChild;
                }
                // pred的右子节点为空，将pred的右子节点指向root；root = root.left，继续遍历左子树
                if(pred.rightChild == null) {
                    pred.rightChild = root;
                    root = root.leftChild;
                } else {
                    // 右子节点不为空，将root加入结果，左子树已完成遍历，断开pred.right
                    res.add(root.data);
                    pred.rightChild = null;
                    root = root.rightChild;
                }
            } else {
                // 无左子节点，将root加入结果，root = root.right
                res.add(root.data);
                root = root.rightChild;
            }
        }
        return res;
    }

    /**
     * 非递归方式前序遍历：借助栈来进行
     *
     * @param root
     */
    private static void preOrderTraveralWithStack(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            // 从根节点开始，追溯左子节点，并且入栈，直到左子节点为null
            while (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = node.leftChild;
            }
            // 左子节点为null时，说明已经没有左子节点，该节点出栈。
            // 需要回溯到上层父节点
            // 开始找上层父节点的右子节点，找到右子节点后，父节点已经没有用处，则出栈
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }

    /**
     * 前序遍历
     *
     * @param node 树的根节点
     */
    private static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 非递归的方式中序遍历：借助栈来中序遍历
     *
     * @param root
     */
    public static void inOrderTraversalWithStack(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            // 先追溯左子节点
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            // 最底层左子节点已经没有左子节点时，打印该节点数据，出栈。
            // 获取该节点的右子节点，打印
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.data);
                node = node.rightChild;
            }
        }

    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 非递归的方式后序遍历：借助栈来后序遍历
     *
     * @param root
     */
    public static void postOrderTraversalWithStack(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.rightChild;
            } else {
                node = stack.pop();
                node = node.leftChild;
            }
        }

        while (output.size() > 0) {
            TreeNode n = output.pop();
            System.out.print(n.data + "\t");
        }

    }

    /**
     * 借用队列来进行层序遍历
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            // 出队，并打印
            System.out.println(node.data);
            // 一次入队左右子节点
            if(node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }

    /**
     * 构建二叉树
     *
     * @param inputList
     * @return
     */
    private static TreeNode createTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createTree(inputList);
            node.rightChild = createTree(inputList);
        }
        return node;

    }
}
