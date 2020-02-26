package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem429 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> val = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                Node n = queue.poll();
                val.add(n.val);
                queue.addAll(n.children);
            }
            list.add(val);
        }

        return list;
    }


}
