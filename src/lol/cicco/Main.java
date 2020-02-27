package lol.cicco;

import lol.cicco.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Problem224 problem = new Problem224();
        int a = problem.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(a);
    }

}
