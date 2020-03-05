package lol.cicco.leetcode;

public class Problem1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] n = new int[num_people];
        int nowIdx = 0;
        int pre = 0;
        while(candies > 0) {
            int remain = candies - (pre + 1);
            if(remain <= 0) {
                n[nowIdx] += candies;
            } else {
                n[nowIdx] += (pre + 1);
            }
            nowIdx++;
            if(nowIdx == n.length) {
                nowIdx = 0;
            }
            pre++;
            candies = remain;
        }
        return n;
    }
}
