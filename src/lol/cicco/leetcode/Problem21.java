package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 链式归并
        ListNode pre = new ListNode(0);
        ListNode node = pre;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            node = node.next;
        }

        while(l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }

        while(l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return pre.next;
    }
}
