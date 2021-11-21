package com.bikercoder.study.algorithm.linkedList;

/**
 * @author caoguo
 * @Description： 234. 回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/solution/
 * @date：2021/11/21 8:58 下午
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    private static ListNode frontPoint;

    /**
     * 递归 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        frontPoint = head;
        return check(head);
    }

    private static boolean check(ListNode currentNode) {
        if (currentNode != null) {
            if (!check(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPoint.val) {
                return false;
            }
            frontPoint = frontPoint.next;
        }
        return true;
    }
}
