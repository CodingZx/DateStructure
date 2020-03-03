package lol.cicco.leetcode;

public class Problem75 {
    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int n : nums) {
            if (n == 0) {
                a++;
            }
            if (n == 1) {
                b++;
            }
            if (n == 2) {
                c++;
            }
        }
        int idx = 0;
        for (int i = 0; i < a; i++) {
            nums[idx++] = 0;
        }

        for (int i = 0; i < b; i++) {
            nums[idx++] = 1;
        }

        for (int i = 0; i < c; i++) {
            nums[idx++] = 2;
        }
    }
}
