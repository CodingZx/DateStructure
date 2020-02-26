package lol.cicco;

import lol.cicco.leetcode.*;

public class Main {

    public static void main(String[] args) {

        Problem138 problem = new Problem138();

        Problem138.Node node7 = new Problem138.Node(7);
        Problem138.Node node13 = new Problem138.Node(13);
        Problem138.Node node11 = new Problem138.Node(11);
        Problem138.Node node10 = new Problem138.Node(10);
        Problem138.Node node1 = new Problem138.Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;


        Problem138.Node res = problem.copyRandomList(node7);

        System.out.println(res);
    }

}
