package cn.hello.jay.practice.leetcode.q_1532;

/**
 * @author 周健以
 * @Date 2020年06月29日
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        print(head);

        ListNode res = new Solution().deleteNode(head, 9);
        print(res);
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode node = prev.next;
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
                break;
            }
            prev = node;
            node = node.next;
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