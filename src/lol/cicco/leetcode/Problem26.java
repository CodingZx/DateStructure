package lol.cicco.leetcode;

public class Problem26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1 || nums.length == 0) return nums.length;


        int start = 1;
        int cur = 0;

        while(start < nums.length) {
            if(nums[cur] != nums[start]) {
                nums[++cur] = nums[start];
            }
            start ++;
        }

        return cur + 1;
    }
}
