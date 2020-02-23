package lol.cicco.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 0) { // 绝对值不可能为负数
            return false;
        }
        // 分割桶
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long bucket = getBucket(t, nums[i]); // 分割桶
            Integer idx = map.get(bucket);
            if (idx != null && i - idx <= k && Math.abs(nums[i] - nums[idx]) <= t) {
                return true;
            }
            // 右滑动
            idx = map.get(bucket + 1);
            if (idx != null && i - idx <= k && Math.abs(nums[i] - nums[idx]) <= t) {
                return true;
            }
            // 左滑动
            idx = map.get(bucket - 1);
            if (idx != null && i - idx <= k && Math.abs(nums[i] - nums[idx]) <= t) {
                return true;
            }
            map.put(bucket, i);
        }

        return false;
    }

    private long getBucket(long width, int num) {
        if(width == 0) { // 0的话 实际是判断是否有相同元素
            width = width + 1;
        }
        if (num < 0) {
            return num / width - 1;
        }
        return num / width;
    }
}
