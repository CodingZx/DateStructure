package lol.cicco.leetcode;


public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode root = pre;

        while (head != null) {
            ListNode now = head;

            boolean endFlag = false;
            for (int i = 1; i < k; i++) {
                if(head.next == null) {
                    endFlag = true;
                    break;
                }
                head = head.next;
            }

            if(endFlag) {
                root.next = now;
                break;
            }

            ListNode remain = head.next;
            head.next = null;

            root.next = reverse(now);
            while (root.next != null) {
                root = root.next;
            }
            head = remain;

        }
        return pre.next;
    }

    private ListNode reverse(ListNode root) {
        ListNode pre = new ListNode(0);

        while (root != null) {
            ListNode remain = root.next;
            root.next = pre.next;
            pre.next = root;
            root = remain;
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
