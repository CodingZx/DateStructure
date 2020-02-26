package lol.cicco.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new LinkedList<>();

        visit(root, vals);

        return vals;
    }

    private void visit(TreeNode node, List<Integer> val) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            visit(node.left, val);
        }
        val.add(node.val);
        if(node.right != null) {
            visit(node.right, val);
        }
    }

    // 非递归
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new LinkedList<>();

        List<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                vals.add(cur.val);
                cur = cur.right;
            }
        }

        return vals;
    }
     */

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

}
