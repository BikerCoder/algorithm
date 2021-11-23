package com.bikercoder.study.algorithm.linkedList;

/**
 * @author caoguo
 * @Description： 147. 对链表进行插入排序  https://leetcode-cn.com/problems/insertion-sort-list/
 * @date：2021/11/23 10:51 下午
 **/
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(2);
        insertionSortList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 时间复杂度O(n平方) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
