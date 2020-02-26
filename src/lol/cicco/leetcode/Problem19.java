package lol.cicco.leetcode;


public class Problem19 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 到达末尾 说明是删除第一个节点
        if (fast == null) {
            return head.next;
        }
        // 将n跑完后.. 剩余的其实就是从0开始的第几个节点 length - n
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 移除
        slow.next = slow.next.next;
        return head;
    }

    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int length = 0;

        ListNode midNode = head;
        ListNode lastNode = head;
        // 获得链表长度
        while (lastNode != null && lastNode.next != null) {
            midNode = midNode.next;
            lastNode = lastNode.next.next;

            length += 2;
        }
        if (lastNode != null) {
            length += 1;
        }

        // 将n从倒数转为正数
        n = length - n;
        if (n == 0) {
            // 如果为第一个节点.. 直接把后继节点返回
            return head.next;
        }

        // 当length为奇数时, mid为第(length + 1) / 2个节点
        // 当length为偶数时, mid为第(length / 2) + 1个节点
        int midNum = getMidNum(length);

        int nowNum;
        ListNode preNode;
        if (n > midNum) {
            preNode = midNode;
            nowNum = midNum;
        } else {
            preNode = head;
            nowNum = 1;
        }
        // 找到前序位置
        for (int i = nowNum; i < n; i++) {
            preNode = preNode.next;
        }
        // 移除节点
        preNode.next = preNode.next.next;
        return head;
    }

    private int getMidNum(int length) {
        if (length % 2 == 0) {  // 偶数
            return (length / 2) + 1;
        } else {  // 奇数
            return (length + 1) / 2;
        }
    }
    */
}
