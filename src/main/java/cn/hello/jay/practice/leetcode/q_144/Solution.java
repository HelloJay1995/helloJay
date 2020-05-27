package cn.hello.jay.practice.leetcode.q_144;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周健以
 * @Date 2020年05月26日
 */
public class Solution {

    public static void main(String[] args) {
        /*
         *                  1
         *              2       3
         *          4      5 6      7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        new Solution().preorderTraversal(root);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(list, root);
        return list;
    }

    public void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}