package cn.hello.jay.practice.leetcode.q_876;

/**
 * @author 周健以
 * @Date 2020年05月21日
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode listNode = solution.middleNode(head);
        System.out.println(listNode);
    }


    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode first = head;
        while (first != null) {
            first = first.next;
            length++;
        }

        int index = length / 2;
        ListNode node = head;

        for (int i = 0; i < length; i++) {
            if (i == index) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}