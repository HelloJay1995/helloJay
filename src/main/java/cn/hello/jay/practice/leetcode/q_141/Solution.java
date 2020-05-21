package cn.hello.jay.practice.leetcode.q_141;

import java.util.HashSet;

/**
 * @author 周健以
 * @Date 2020年05月20日
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }


    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = null;
            boolean isSus = hashSet.add(curr);
            if (!isSus) {
                return true;
            }
            curr = nextNode;
        }
        return false;
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