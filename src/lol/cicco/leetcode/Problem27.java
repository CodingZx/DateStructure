package lol.cicco.leetcode;

public class Problem27 {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;

        int startIdx = 0;
        int endIdx = nums.length - 1;

        while(startIdx < endIdx) {
            if(nums[endIdx] == val) {
                endIdx --;
                len --;
                continue;
            }
            // nums[endIdx] 绝对不等于val
            if(nums[startIdx] == val) {
                int temp = nums[endIdx];
                nums[endIdx] = nums[startIdx];
                nums[startIdx] = temp;
            }
            startIdx ++;
        }

        if(nums[endIdx] == val) {
            len --;
    }
        return len;
    }
}
