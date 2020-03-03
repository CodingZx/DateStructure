package lol.cicco;

import lol.cicco.leetcode.*;
import lol.cicco.leetcode.interview.Question17_19;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Question17_19 problem = new Question17_19();

        System.out.println(Arrays.toString(problem.missingTwo(new int[]{1,2,5,6})));

    }

}
