package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode root = pre;
        while(head != null) {
            ListNode left = head;
            ListNode right = head.next;

            head = right == null ? null : right.next;

            root.next = swap(left, right);
            while(root.next != null) {
                root = root.next;
            }
        }

        return pre.next;
    }

    private ListNode swap(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;

        left.next = null;
        right.next = left;
        return right;
    }
}
