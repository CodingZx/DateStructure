package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> value = new ArrayList<>();
        if(root == null) {
            return value;
        }

        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nowLength = queue.size();

            double sum = 0;
            for (int i = 0; i < nowLength; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            value.add(sum / nowLength);
        }

        return value;
    }

}
