package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem111 {

    public int minDepth(TreeNode root) {
        // 叶节点返回0
        if(root == null) return 0;
        // 找到左子树高度
        int left = minDepth(root.left);
        // 找到右子树高度
        int right = minDepth(root.right);
        // 其中一棵子树为空
        if(left == 0 || right == 0) {
            // 返回当前树高
            return left + right + 1;
        }
        // 找到最小树高 并返回当前树高
        return Math.min(left, right) + 1;
    }

    /*
    // 非递归
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        // 广度优先
        class Data {
            TreeNode node;
            int depth;

            Data(TreeNode node, int depth){
                this.node = node;
                this.depth = depth;
            }
        }
        // 辅助队列
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(root, 1));

        while (!queue.isEmpty()) {
            int nowLength = queue.size();

            for (int i = 0; i < nowLength; i++) {
                Data data = queue.poll();

                if(data.node.left == null && data.node.right == null) {
                    return data.depth;
                }

                if (data.node.left != null) {
                    queue.add(new Data(data.node.left, data.depth + 1));
                }
                if (data.node.right != null) {
                    queue.add(new Data(data.node.right, data.depth + 1));
                }
            }
        }

        return 0;
    }
    */

}
