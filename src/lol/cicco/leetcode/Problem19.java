package lol.cicco.leetcode;

import lol.cicco.leetcode.struct.ListNode;

public class Problem19 {

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

}
