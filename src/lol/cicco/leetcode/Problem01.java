package lol.cicco.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {
    public int[] twoSum(int[] nums, int target) {
        // 存储 值-下标
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int rem = target - nums[i];
            Integer val = hash.get(rem);
            // 和已经存储的值比较 是否有相加等于target的值.
            if (val != null) {
                return new int[]{val, i};
            }
            // 无匹配项
            hash.put(nums[i], i);
        }
        return null;
    }
}
