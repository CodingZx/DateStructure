package lol.cicco.leetcode;

import java.util.Arrays;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;

        Arrays.sort(intervals, (o1,o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int[][] arr = new int[intervals.length][2];
        arr[0] = intervals[0];
        int arrIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = arr[arrIdx];
            int[] now = intervals[i];

            if(now[0] > pre[1]) {
                arr[arrIdx+1] = now;
                arrIdx ++;
                continue;
            }

            // [1,3] [0,4]
            if(now[0] <= pre[0]) {
                pre[0] = now[0];
                if(now[1] >= pre[1]) {
                    pre[1] = now[1]; // 合并
                }
                continue;
            }

            if(now[1] < pre[1]) {
                // 包含关系
                continue;
            }
            if(now[1] > pre[1]) {
                pre[1] = now[1];
            }
        }
        int[][] res = new int[arrIdx+1][2];
        System.arraycopy(arr, 0, res, 0, arrIdx+1);
        return res;
    }
}
