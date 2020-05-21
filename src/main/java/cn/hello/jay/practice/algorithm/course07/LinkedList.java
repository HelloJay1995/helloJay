package cn.hello.jay.practice.algorithm.course07;

/**
 * @author 周健以
 * @Date 2020年05月20日
 */
public class LinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        final Node<E> tail = last;
        final Node<E> newNode = new Node<>(e, tail, null);
        if (first == null) {
            first = last = newNode;
        } else {
            last = last.next = newNode;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        if (first == null) {
            return true;
        }
        Node<E> node;
        for (node = first; node != null; node = node.next) {
            if (o.equals(node.item)) {
                Node<E> prev = node.prev;
                Node<E> next = node.next;

                if (prev == null) {
                    first = node.next;
                    if (next!=null) {
                        next.prev = null;
                    }
                    node = null;
                    size--;
                    return true;
                }

                if (next == null) {
                    last = node.prev;
                    node = null;
                    size--;
                    return true;
                }

                prev.next = next;
                next.prev = prev;
                next = null;
                size--;
                return true;
            }
        }
        return true;
    }


    class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            String prevStr = prev == null ? null : prev.item + "";
            String nextStr = next == null ? null : next.item + "";
            return "Node{item=" + item + ",prev=" + prevStr + ", next=" + nextStr + "}";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node;
        for (node = first; node != null; node = node.next) {
            sb.append(node.toString());
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
