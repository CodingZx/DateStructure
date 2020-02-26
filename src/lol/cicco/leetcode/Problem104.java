package lol.cicco.leetcode;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        // 找到左子树高度
        int left = maxDepth(root.left);
        // 找到右子树高度
        int right = maxDepth(root.right);
        // 其中一棵子树为空
        if(left == 0 || right == 0) {
            // 返回当前树高
            return left + right + 1;
        }
        // 找到最大树高 并返回当前树高
        return Math.max(left, right) + 1;
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
