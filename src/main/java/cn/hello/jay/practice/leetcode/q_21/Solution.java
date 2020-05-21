package cn.hello.jay.practice.leetcode.q_21;

/**
 * @author 周健以
 * @Date 2020年05月21日
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        System.out.println(solution.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 把两个列表合并，来个中间列表
        ListNode fadeNode = new ListNode(-1);
        ListNode prev = fadeNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 还有一段没有处理掉的
        // 当前的prev器是是是next指针的队尾node
        prev.next = l1 != null ? l1 : l2;

        return fadeNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}