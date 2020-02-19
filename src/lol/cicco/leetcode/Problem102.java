package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {

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

    /*
    // 非递归
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        TreeNode endNode = new TreeNode(0);
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(endNode);

        List<Integer> values = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == endNode) {
                // 相同对象  当前层次遍历完成
                if(!values.isEmpty()) {
                    res.add(values);
                    values = new LinkedList<>();
                }
                continue;
            }
            values.add(node.val);

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

            TreeNode nextNode = queue.peek();
            if(nextNode  == endNode) {
                // 当前层级已经遍历完成
                queue.add(endNode);
            }
        }

        return res;
    }
     */
}
