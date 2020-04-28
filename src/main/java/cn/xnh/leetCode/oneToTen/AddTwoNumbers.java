package cn.xnh.leetCode.oneToTen;

/**
 * @author : xn-h
 * @date: 2019-08-29  10:24
 * @description: 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    /**
     * 简易链表
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param l1 链表1
     * @param l2 链表2
     * @author : xn-h
     * @date: 2019-08-29  10:34
     * @description: 链表1  + 链表2  返回 链表
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 时间复杂度：O(max(m, n))O(max(m,n))，假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，上面的算法最多重复 \max(m, n)max(m,n) 次。
     *
     * 空间复杂度：O(max(m, n))O(max(m,n))， 新列表的长度最多为 \max(m,n) + 1max(m,n)+1。
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        //防止 原链表 移动到最后
        ListNode p1 = l1, p2 = l2,curr = result;

        int carryOn = 0;
        // 需要全部循环两个链表
        while (p1 != null || p2 != null) {
            //获取当前值  为 当前链表 相加
            int current = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carryOn;

            //获取 当前值的 余数  就是结果 链表的 当前值
            int remainder = current % 10;

            curr.next = new ListNode(remainder);

            curr = curr.next;

            //取商  用于后面链表+1
            carryOn = current / 10;

            //链表 循环 往下
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carryOn > 0) {
            curr.next = new ListNode(carryOn);
        }
        return result.next;
    }
}
