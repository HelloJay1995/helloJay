package cn.hello.jay.practice.leetcode.q_262;

/**
 * @author 周健以
 * @Date 2020年05月20日
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode nextNode2 = head.next = new ListNode(2);
        ListNode nextNode3 = nextNode2.next = new ListNode(3);
        ListNode nextNode4 = nextNode3.next = new ListNode(4);
        ListNode nextNode5 = nextNode4.next = new ListNode(5);

        System.out.println(head);
        ListNode newHead = reverseList(head);
        System.out.println(newHead);
    }

//    public static ListNode reverseList(ListNode head) {
//        ListNode newHead = null;
//        if (head == null) {
//            return null;
//        }
//        ListNode next = head.next;
//        if (next != null) {
//            newHead = reverseList(next);
//        }
//        if (newHead == null) {
//            newHead = new ListNode(head.val);
//        } else {
//            newHead = addNode(newHead, new ListNode(head.val));
//        }
//        return newHead;
//    }
//
//
//    private static ListNode addNode(ListNode head, ListNode addNode) {
//        if (head.next != null) {
//            head.next = addNode(head.next, addNode);
//        } else {
//            head.next = addNode;
//        }
//        return head;
//    }

//    public static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode p = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
//    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
