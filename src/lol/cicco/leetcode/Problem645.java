package lol.cicco.leetcode;

public class Problem645 {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        int[] hash = new int[nums.length + 1];

        for (int a : nums) {
            hash[a]++;
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) {
                arr[0] = i;
            }
            if (hash[i] == 0) {
                arr[1] = i;
            }
            if (arr[0] != 0 && arr[1] != 0) {
                return arr;
            }
        }
        return arr;
    }
}
