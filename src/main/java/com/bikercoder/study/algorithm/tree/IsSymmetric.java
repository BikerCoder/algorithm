package com.bikercoder.study.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author caoguo
 * @Description： 力扣 101. 对称二叉树 https://leetcode-cn.com/problems/symmetric-tree/submissions/
 * @date：2021/10/28 8:40 下午
 **/
public class IsSymmetric {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{2, 5, 7, null, 3, null, null, 4, null,
                null, 5, 4, null, null, 7, 3, null}));
        TreeNode root = MyTree.createTree(inputList);
        System.out.println(isSymmetric(root));
    }


    /**
     * 两个树同事满足两个条件则互为镜像树 1、两个树的根节点值相等 2、每个树的左子树和另外一个树的右子树互为镜像对称
     * 通过「同步移动」两个指针的方法来遍历这棵树，l 指针和 r 指针一开始都指向这棵树的根，随后 r 右移时，l 左移，r 左移时，l 右移。
     * 每次检查当前 r 和 l 节点的值是否相等，如果相等再判断左右子树是否对称
     * <p>
     * 递归 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return l.data == r.data && check(l.leftChild, r.rightChild) && check(l.rightChild, r.leftChild);
    }
}
