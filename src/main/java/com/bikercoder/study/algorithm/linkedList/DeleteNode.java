package com.bikercoder.study.algorithm.linkedList;

/**
 * @author caoguo
 * @Description： 237. 删除链表中的节点 https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @date：2021/11/8 8:54 下午
 **/
public class DeleteNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(6);
        deleteNode(node.next.next);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 和下一个节点交换 时间复杂度和空间复杂度都是O(1)
     * from leetcode评论区：既然不能先删除自己，那就把自己整容成儿子，再假装自己就是儿子来养活孙子 hhhhh
     *
     * @param node
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
