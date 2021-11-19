package com.bikercoder.study.algorithm.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caoguo
 * @Description： 160. 相交链表 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @date：2021/11/18 9:08 下午
 **/
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);
        headA.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(1);
        headB.next = headA.next;
        headB.next.next = new ListNode(8);
        System.out.println(getIntersectionNode2(headA, headB).val);
    }

    /**
     * 哈希
     * 时间复杂度O(n+m) n为链表A的长度 m为链表B的长度
     * 空间复杂度O(n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 双指针 走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
     * 时间复杂度O(n+m)
     * 空间复杂度O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
