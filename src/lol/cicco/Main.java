package lol.cicco;

import lol.cicco.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Problem445 problem = new Problem445();

        Problem445.ListNode node1 = new Problem445.ListNode(9);
        Problem445.ListNode node2 = new Problem445.ListNode(1);
        Problem445.ListNode node3 = new Problem445.ListNode(6);
        Problem445.ListNode node4 = new Problem445.ListNode(0);
        node1.next = node2;
        node2.next = node3;

        problem.addTwoNumbers(node1, node4);

    }

}
