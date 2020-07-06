package cn.hello.jay.practice.leetcode.q_2;

/**
 * @author 周健以
 * @Date 2020年07月01日
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = l1;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            l1.val = val % 10;

            if (l1.next == null) {
                if (l2.next != null) {
                    l1.next = l2.next;
                    l2.next = new ListNode(0);
                } else if (carry > 0) {
                    l1.next = new ListNode(1);
                    break;
                }
            } else if (l2.next == null) {
                l2.next = new ListNode(0);
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return sentinel.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
