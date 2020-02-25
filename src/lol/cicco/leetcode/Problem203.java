package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while(temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return pre.next;
    }
}
