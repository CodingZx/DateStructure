package lol.cicco.leetcode;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode left = pre;
        for (int i = 0; i < m - 1; i++) {
            left = left.next;
        }

        ListNode temp = left.next; // 前面不需要反转的部分

        ListNode reversePre = new ListNode(0);
        ListNode tail = null;
        while(temp != null) {
            if(m > n) {
                tail.next = temp;
                break;
            }

            ListNode next = temp.next;
            temp.next = reversePre.next;
            reversePre.next = temp;

            if(tail == null) {
                tail = temp;
            }

            temp = next;
            m++;
        }
        left.next = reversePre.next;

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
