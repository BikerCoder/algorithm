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
        // 定义哑节点，方便再head前插入节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 定义有序链表的最后一个节点，初始为head；定义curr为需要插入有序链表的节点，初始为head.next
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            // 如果lastSorted的值 <= curr的值，则表示两个值本身就是升序的，直接将lastSorted后移一位
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                // 否则从dummyHead开始遍历，找到curr插入的前一个元素prev
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                // curr插入到有序链表中
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
