package lol.cicco.leetcode;

public class Problem136 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int n : nums) {
            a ^= n;
        }
        return a;
    }
}
