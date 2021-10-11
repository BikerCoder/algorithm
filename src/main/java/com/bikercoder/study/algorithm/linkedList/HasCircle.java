package com.bikercoder.study.algorithm.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 力扣 141.环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 * @date：2021/10/10 10:27 下午
 **/
public class HasCircle {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = node.next.next;
        System.out.println(hasCircle2(node));
    }

    /**
     * 借助哈希 时间复杂度 O(n),空间复杂度O(n)
     *
     * @param node
     * @return
     */
    public static boolean hasCircle(ListNode node) {
        Set<ListNode> set = new HashSet<>();

        while (node != null) {
            if (set.contains(node)) {
                return true;
            } else {
                set.add(node);
            }
            node = node.next;
        }

        return false;
    }

    /**
     * 快慢指针 时间复杂度 O(n),空间复杂度O(1)
     *
     * @param node
     * @return
     */
    public static boolean hasCircle2(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
