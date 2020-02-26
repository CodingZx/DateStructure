package lol.cicco.leetcode;

public class Problem206 {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode pre = new ListNode(0);

        while(head != null) {
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }

        return pre.next;
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
