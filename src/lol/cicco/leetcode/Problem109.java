package lol.cicco.leetcode;

import java.util.Arrays;

public class Problem109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode pre = head;
        ListNode fast = head;
        ListNode low = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = low;
            low = low.next;
        }

        pre.next = null;

        // 找到中间节点
        TreeNode node = new TreeNode(low.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(low.next);
        return node;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
