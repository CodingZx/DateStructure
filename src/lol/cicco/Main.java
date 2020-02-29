package lol.cicco;

import lol.cicco.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Problem283 problem = new Problem283();

        int[] arr = new int[]{1,0,1,1,20,1,0,0};
        problem.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

}
