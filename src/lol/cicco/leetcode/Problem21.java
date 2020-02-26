package lol.cicco.leetcode;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 链式归并
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;

        if(l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }

        ListNode node = head;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        while(l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }

        while(l2 != null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        return head;
    }


    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
