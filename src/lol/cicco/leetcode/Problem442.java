package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length / 2 + 1);
        int[] arr = new int[nums.length + 1];
        for(int n : nums) {
            if(arr[n] != 0){
                list.add(n);
            } else {
                arr[n] = n;
            }
        }
        return list;
    }

    /*
    // 原地Hash
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++) {
            int val = Math.abs(nums[i]);
            if(nums[val - 1] < 0) {
                list.add(val);
            } else {
                nums[val - 1] = -Math.abs(nums[val - 1]);
            }
        }
        return list;
    }
    */
}
