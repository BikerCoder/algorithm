package com.bikercoder.study.algorithm.linkedList;

/**
 * @author caoguo
 * @Description： 力扣 206.反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 * @date：2021/10/18 3:03 下午
 **/
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    /**
     * 迭代法 时间复杂度O(n),空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
