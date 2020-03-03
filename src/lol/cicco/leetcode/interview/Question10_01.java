package lol.cicco.leetcode.interview;

import java.util.Arrays;

public class Question10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = m, b = 0; i < A.length; i++, b++) {
            A[i] = B[b];
        }
        Arrays.sort(A);
    }
}
