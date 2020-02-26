package lol.cicco.leetcode;

public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;


        int len = 0;
        ListNode t = head;
        while(t != null) {
            t = t.next;
            len ++;
        }

        if(k >= len) {
            k = k % len;
        }

        if(k == 0) {
            return head;
        }

        k = len - k;

        ListNode root = head;
        ListNode pre = head;
        while(k-- > 0) {
            pre = head;
            head = head.next;
            if(head == null) {
                head = root;
            }
        }

        ListNode left = pre.next;
        pre.next = null;

        ListNode next = left;
        while(next.next != null) {
            next = next.next;
        }
        next.next = root;

        return left;
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
