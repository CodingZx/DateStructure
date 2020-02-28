package lol.cicco.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
    public int majorityElement(int[] nums) {
        int m = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            Integer count = map.get(n);
            if(count == null) {
                map.put(n, 1);
            } else {
                if(count + 1 > m) {
                    return n;
                }
                map.put(n, count + 1);
            }
        }
        return nums[0];
    }
    */

}
