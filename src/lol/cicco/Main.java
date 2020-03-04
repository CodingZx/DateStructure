package lol.cicco;

import lol.cicco.leetcode.*;
import lol.cicco.leetcode.interview.Question17_19;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Problem966 problem = new Problem966();

        //["Yellow"]
        //["yellow"]
        //
        System.out.println(Arrays.toString(problem.spellchecker(new String[]{"Yellow"}, new String[]{"yellow"})));

    }

}
