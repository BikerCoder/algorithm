package com.bikercoder.study.algorithm.linkedList;

/**
 * @author caoguo
 * @Description： 328. 奇偶链表 https://leetcode-cn.com/problems/odd-even-linked-list/
 * @date：2021/11/22 5:15 下午
 **/
public class OddEvenList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode listNode = oddEvenList(node);
        System.out.println("end");
    }

    /**
     * 分离节点后合并 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}
