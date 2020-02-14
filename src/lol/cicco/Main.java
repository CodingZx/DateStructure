package lol.cicco;

import lol.cicco.leetcode.Problem19;
import lol.cicco.leetcode.struct.ListNode;

public class Main {

    public static void main(String[] args) {

        Problem19 problem = new Problem19();

        foreachList(problem.removeNthFromEnd(createList(5), 2));
        foreachList(problem.removeNthFromEnd(createList(7), 2));
        foreachList(problem.removeNthFromEnd(createList(6), 3));
        foreachList(problem.removeNthFromEnd(createList(4), 4));
    }

    private static ListNode createList(int length) {
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        for (int i = 1; i <= length; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return pre.next;
    }

    private static void foreachList(ListNode node) {
        if (node == null) {
            System.out.println("list is null..");
            return;
        }
        StringBuilder builder = new StringBuilder();
        while (true) {
            builder.append(node.val);
            if (node.next == null) {
                break;
            }
            builder.append(" -> ");
            node = node.next;
        }
        System.out.println(builder.toString());
    }
}
