package com.bikercoder.study.algorithm.linkedList;

import java.util.Stack;

/**
 * @author caoguo
 * @Description： 力扣 19. 删除链表的倒数第 N 个结点 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @date：2021/10/20 8:47 下午
 **/
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd2(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 遍历求出链表长度，第一个节点坐标为1，将length - n + 1 个节点移除
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param head
     * @param n    倒数第n个节点
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        ListNode curr = dummy;
        for (int i = 0; i < length - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }

    /**
     * 栈 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        Stack<ListNode> stk = new Stack<>();
        while (curr != null) {
            stk.push(curr);
            curr = curr.next;
        }

        for (int i = 0; i < n; i++) {
            stk.pop();
        }
        ListNode prev = stk.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }
}
