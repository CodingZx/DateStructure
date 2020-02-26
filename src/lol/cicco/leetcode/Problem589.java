package lol.cicco.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem589 {
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

    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();

        List<Integer> val = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            val.add(n.val);

            for (int i = n.children.size() - 1; i >= 0; i--) {
                stack.push(n.children.get(i));
            }
        }
        return val;
    }
}
