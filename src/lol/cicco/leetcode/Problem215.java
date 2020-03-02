package lol.cicco.leetcode;

import java.util.Arrays;

public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
