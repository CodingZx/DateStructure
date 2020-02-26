package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        processData(root, 0, levels);

        return levels;
    }

    private void processData(TreeNode node, int level, List<List<Integer>> dataList) {
        if(dataList.size() == level) {
            dataList.add(new LinkedList<>());
        }
        if(level % 2 == 0) {
            dataList.get(level).add(0, node.val);
        } else {
            dataList.get(level).add(node.val);
        }

        if(node.left != null) {
            processData(node.left, level + 1, dataList);
        }
        if(node.right != null) {
            processData(node.right, level + 1, dataList);
        }
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
