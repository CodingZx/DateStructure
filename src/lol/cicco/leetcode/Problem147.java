package lol.cicco.leetcode;

public class Problem147 {
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

    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;

        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode tail = root;
        ListNode cur = head;

        while(cur != null) {
            ListNode pre = root;
            ListNode remain = cur.next;

            // 将当前链表断开  后面一个节点一个节点慢慢插入
            cur.next = null;
            if(tail.val < cur.val) {
                tail.next = cur;
                tail = tail.next;
            } else {
                // 需要向前面插入
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
            }

            cur = remain;
        }

        return root.next;
    }
}
