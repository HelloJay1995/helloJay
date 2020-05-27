package cn.hello.jay.practice.algorithm.course24;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 周健以
 * @Date 2020年05月27日
 */
public class BinarySearchTree {
    private Node tree;

    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        obj.add(5);
        obj.add(3);
        obj.add(8);
        obj.add(1);
        obj.add(4);
        obj.add(7);
        obj.add(12);
        obj.add(10);
        obj.add(11);
        obj.add(13);
        obj.print();
        System.out.println(JSON.toJSONString(obj.find(5).data));
        obj.delete(5);
        obj.print();
        System.out.println(JSON.toJSONString(obj.findMin().data));
        System.out.println(JSON.toJSONString(obj.findMax().data));
        System.out.println(JSON.toJSONString(obj.findPrev(11).data));
    }

    public void add(int item) {
        if (tree == null) {
            tree = new Node(item);
            return;
        }
        Node node = tree;
        while (node != null) {
            if (item < node.data) {
                if (node.left == null) {
                    node.left = new Node(item);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Node(item);
                    return;
                }
                node = node.right;
            }
        }
    }

    public void delete(int item) {
        Node node = this.tree;
        Node prev = null;
        while (node != null && node.data != item) {
            node = item < node.data ? node.left : node.right;
        }
        if (node == null) {
            // 都找不到，就别删了
            return;
        }

        // 2.如果有两个叶子节点，先找到右节点的最小节点，将最小节点的值与待删除的值替换，其实就是保证了待删除节点只有0个或者1个子节点，这样处理起来会比较方便统一
        if (node.left != null && node.right != null) {
            Node min = node.right;
            Node minPrev = node;

            while (min.left != null) {
                minPrev = min;
                min = min.left;
            }
            // 找到了待删除节点的右节点的最小节点，那就将内存中的data值修改掉
            node.data = min.data;
            // 然后把统一成一个套路，放到1里处理
            node = min;
            prev = minPrev;
        }

        // 1.先来处理一个子节点或者没有子节点的情况吧
        // 默认没有子节点
        Node child = null;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        }

        // 3.删除
        if (prev == null) {
            // 删除单子节点的根节点
            tree = child;
        } else if (prev.left == node) {
            // 删除左节点
            prev.left = child;
        } else {
            prev.right = child;
        }

    }

    public Node find(int item) {
        Node node = tree;
        while (node != null && node.data != item) {
            node = item < node.data ? node.left : node.right;
        }
        return node;
    }

    public Node findMin() {
        Node node = this.tree;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node findMax() {
        Node node = this.tree;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node findPrev(int item) {
        Node prev = null;
        Node node = this.tree;
        while (node != null && node.data != item) {
            prev = node;
            node = node.left;
        }
        return prev;
    }

    public void print() {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (tree != null) {
            queue.add(tree);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.getFirst();
                tmp.add(node.data);
                queue.removeFirst();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            results.add(tmp);
        }
        System.out.println(JSON.toJSONString(results));
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
