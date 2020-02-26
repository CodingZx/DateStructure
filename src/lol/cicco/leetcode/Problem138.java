package lol.cicco.leetcode;

import java.util.HashMap;

public class Problem138 {

    // Hash大法好
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node root = new Node(0);
        Node tmp = root;
        while(head != null) {
            Node node = map.get(head);
            Node resNode;
            if(node != null) {
                resNode = node;
            } else {
                resNode = new Node(head.val);
                map.put(head, resNode);
            }

            if(head.random != null) {
                if(head.random == head) {
                    resNode.random = resNode;
                } else {
                    Node randomNew = map.get(head.random);
                    if(randomNew == null) {
                        randomNew = new Node(head.random.val);
                        map.put(head.random, randomNew);
                    }
                    resNode.random = randomNew;
                }
            }

            tmp.next = resNode;
            tmp = tmp.next;
            head = head.next;
        }
        return root.next;
    }


    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
