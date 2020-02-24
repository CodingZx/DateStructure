package lol.cicco.leetcode;

public class Problem287 {
    public int findDuplicate(int[] nums) {
        // 题目一定有环
        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast) {
                // 有环
                fast = 0;
                while(slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}
