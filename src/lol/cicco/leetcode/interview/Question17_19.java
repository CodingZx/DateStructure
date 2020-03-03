package lol.cicco.leetcode.interview;

public class Question17_19 {
    public int[] missingTwo(int[] nums) {
        int a1 = -1;
        int a2 = -1;
        for (int n : nums) {
            int idx = Math.abs(n) - 1;
            if (idx >= nums.length) {
                // 要么a1  要么a2
                if (idx == nums.length) {
                    a1 = idx;
                } else {
                    a2 = idx;
                }
            } else {
                nums[idx] = -nums[idx];
            }
        }
        int[] arr = new int[2];
        int count = 0;
        if (a1 < 0) {
            arr[count++] = nums.length + 1;
        }
        if (a2 < 0) {
            arr[count++] = nums.length + 2;
        }
        if (count == 2) {
            return arr;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                arr[count++] = i + 1;
            }

            if (count == 2) {
                return arr;
            }
        }
        return null;
    }
}
