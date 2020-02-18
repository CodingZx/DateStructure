package lol.cicco.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length / 2 + 1);
        int[] arr = new int[nums.length + 1];
        for (int n : nums) {
            arr[n] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    /*
    // 原地标记
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++) {
            int val = Math.abs(nums[i]);
            nums[val - 1] = -Math.abs(nums[val - 1]);
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
    */
}
