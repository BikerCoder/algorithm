package com.bikercoder.study.algorithm.linkedList;

/**
 * @author caoguo
 * @Description： 148. 排序链表 https://leetcode-cn.com/problems/sort-list/
 * @date：2021/11/24 10:31 下午
 **/
public class SortList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(2);
        sortList2(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 自顶向下归并排序 时间复杂度O(nlogn) 空间复杂度O(logn)
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);
        return MergeTwoLists.mergeTwoLists2(left, right);
    }

    /**
     * 自底向上归并排序 时间复杂度O(nlogn) 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        for (int i = 1; i < len; i <<= 1) {
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;
            while (curr != null) {
                ListNode a = curr;
                ListNode b = splitList(a, i);
                curr = splitList(b, i);
                prev.next = MergeTwoLists.mergeTwoLists2(a, b);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }

        }
        return dummyHead.next;
    }

    private static ListNode splitList(ListNode head, int step) {
        if (head == null) return head;
        for (int i = 1; i < step && head.next != null; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
