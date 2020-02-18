package lol.cicco.leetcode;

public class Problem268 {
    public int missingNumber(int[] nums) {
        int numsSum = 0;
        int calcSum = nums.length; //  nums.length * (nums.length + 1) / 2
        int idx = 0;
        for (int n : nums) {
            numsSum += n;
            calcSum += idx;
            idx++;
        }

        return calcSum - numsSum;
    }
}
