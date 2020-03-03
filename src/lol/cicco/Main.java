package lol.cicco;

import lol.cicco.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Problem56 problem = new Problem56();

        int[][] arr = new int[5][2];
        arr[0] = new int[]{1,3};
        arr[1] = new int[]{2,6};
        arr[2] = new int[]{8,10};
        arr[3] = new int[]{15,18};
        arr[4] = new int[]{16,20};

        System.out.println(problem.merge(arr));

    }

}
