package lol.cicco;

import lol.cicco.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Problem707.MyLinkedList problem = new Problem707.MyLinkedList();

        problem.addAtHead(1);
        problem.addAtTail(3);
        problem.addAtIndex(1, 2);

        System.out.println(problem.get(1));
        problem.deleteAtIndex(1);
        System.out.println(problem.get(1));
    }

}
