package cn.hello.jay.practice.leetcode.q_147;

/**
 * @author 周健以
 * @Date 2020年05月22日
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Solution solution = new Solution();
        System.out.println(solution.insertionSortList(head));
    }

    /**
     * 4,2,1,3
     * 第1次：2,4,1,3
     * 第2次：1,2,4,3
     * 第3次：1,2,4,3
     * 第4次：1,2,3,4
     */

    public ListNode insertionSortList(ListNode head) {
        ListNode fadeNode = new ListNode(-1);
        fadeNode.next = head;

        ListNode target = fadeNode;
        while (target != null) {
            ListNode nextNode = target.next;


            target = nextNode;
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