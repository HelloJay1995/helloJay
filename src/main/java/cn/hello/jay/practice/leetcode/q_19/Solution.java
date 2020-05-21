package cn.hello.jay.practice.leetcode.q_19;

/**
 * @author 周健以
 * @Date 2020年05月20日
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode fadeNode = new ListNode(-1);
        fadeNode.next = head;

        Solution solution = new Solution();
        System.out.println(solution.removeNthFromEnd(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 要操作next里的引用，先取一个假节点
        ListNode fadeNode = new ListNode(-1);
        fadeNode.next = head;
        ListNode prev = fadeNode;

        ListNode first = head;
        int length = 0;
        while (first != null) {
            length++;
            first = first.next;
        }


        for (int i = 0; i < length; i++) {
            if (i == length - n) {
                // prev.next肯定不为null，因为队头加了fadeNode
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }

        return fadeNode.next;
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