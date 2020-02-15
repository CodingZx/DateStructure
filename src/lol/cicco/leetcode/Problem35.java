package lol.cicco.leetcode;

public class Problem35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int startIdx = 0;
        int endIdx = nums.length - 1;

        // 折半查找
        while (startIdx < endIdx) {
            int idx = (startIdx + endIdx) / 2;

            if (nums[idx] == target) {
                return idx;
            }
            if (nums[idx] < target) {
                startIdx = ++idx;
            } else {
                endIdx = --idx;
            }
        }
        if(nums[startIdx] < target) {
            return startIdx + 1;
        }
        return startIdx;
    }
}
