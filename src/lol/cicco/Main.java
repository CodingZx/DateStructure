package lol.cicco;

import lol.cicco.leetcode.Problem35;
import lol.cicco.leetcode.Problem88;
import lol.cicco.leetcode.struct.ListNode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Problem88 problem = new Problem88();
        int[] arr1 = new int[]{1,2,3,4,5,0,0,0};
        int[] arr2 = new int[]{1,2,8};

        problem.merge(arr1, 5, arr2, 3);

        System.out.println(Arrays.toString(arr1));
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
