package lol.cicco.leetcode;

import java.util.*;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        LinkedList<List<Integer>> res = new LinkedList<>();
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> vals = new ArrayList<>(len);
            for(int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                vals.add(node.val);
            }
            res.add(vals);
        }
        Collections.reverse(res);
        return res;
    }


    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

}
