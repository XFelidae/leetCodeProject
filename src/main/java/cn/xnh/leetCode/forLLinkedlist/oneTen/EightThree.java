package cn.xnh.leetCode.forLLinkedlist.oneTen;

import cn.xnh.leetCode.forLLinkedlist.ListNode;

/**
 * @author : xn-h
 * @date: 2020-03-10  11:30
 * @description: 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class EightThree {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
    }
}
