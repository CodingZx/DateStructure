package lol.cicco.leetcode;

import java.util.Arrays;

public class Problem179 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, ((o1, o2) -> {
            return (o1+o2).compareTo(o2+o1);
        }));

        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(builder.length() == 0) {
                if(arr[i].equals("0")) {
                    continue;
                }
            }
            builder.append(arr[i]);
        }
        return builder.length() == 0 ? "0" :builder.toString();
    }
}
