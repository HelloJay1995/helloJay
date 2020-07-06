package cn.hello.jay.practice.algorithm.course53;

import com.alibaba.fastjson.JSON;

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

        Solution solution = new Solution();
        System.out.println(JSON.toJSONString(solution.hasCycle(head)));
    }


    public ListNode hasCycle(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
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