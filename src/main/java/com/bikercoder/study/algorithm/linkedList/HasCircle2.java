package com.bikercoder.study.algorithm.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 力扣142.环形链表II https://leetcode-cn.com/problems/linked-list-cycle-ii
 * @date：2021/10/11 4:51 下午
 **/
public class HasCircle2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = node.next.next;
        System.out.println(hasCircle2(node).val);
    }

    /**
     * 哈希表 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public static ListNode hasCircle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode hasCircle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
