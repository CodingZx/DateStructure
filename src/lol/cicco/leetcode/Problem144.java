package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new LinkedList<>();

        List<Integer> val = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            val.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return val;
    }
}
