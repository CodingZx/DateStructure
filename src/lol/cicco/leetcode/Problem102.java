package lol.cicco.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
/*
    // 递归
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        processData(root, 0, levels);

        return levels;
    }

    private void processData(TreeNode node, int level, List<List<Integer>> dataList) {
        if(dataList.size() == level) {
            dataList.add(new ArrayList<>());
        }
        dataList.get(level).add(node.val);

        if(node.left != null) {
            processData(node.left, level + 1, dataList);
        }
        if(node.right != null) {
            processData(node.right, level + 1, dataList);
        }
    }
*/

    // 非递归
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nowLength = queue.size();

            List<Integer> values = new LinkedList<>();
            for (int i = 0; i < nowLength; i++) {
                TreeNode node = queue.poll();
                values.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(values);
        }

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
