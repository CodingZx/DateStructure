package lol.cicco.leetcode;

import java.util.Stack;

public class Problem430 {

    public Node flatten(Node head) {
        Node pre = new Node();
        Node node = pre;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()) {
            head = stack.pop();
            while (head != null) {
                Node remain = head.next;
                Node n = new Node();
                n.val = head.val;
                if (node != pre) {
                    n.prev = node;
                }
                node.next = n;
                node = node.next;

                if (head.child != null) {
                    stack.push(remain);
                    head = head.child;
                } else {
                    head = remain;
                }
            }
        }
        return pre.next;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;
}
