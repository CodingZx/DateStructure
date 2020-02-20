package lol.cicco.leetcode;

public class Problem80 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums){
            if (i < 2 || n > nums[i-2]) {
                // 如果碰见相等.. i不会进入此分支.. 下次找到更大的数值时会将当前位置的数字覆盖...
                nums[i++] = n;
            }
        }

        return i;
    }



    // 我好蛋疼.. 还标记整理... 虽然也99.77%
    /*
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int min = nums[0] - 1;

        int count = 0;
        int next = 1;
        int cur = 0;
        int len = nums.length;

        while (next < nums.length) {
            if (nums[cur] == nums[next]) {
                if (count == 0) {
                    count++;
                    cur++;
                } else {
                    len--;
                }
                next++;
            } else {
                if(count == 0) {
                    cur++;
                    next++;
                } else {
                    // 出现不相等
                    for (int i = cur + 1; i < next; i++) {
                        nums[i] = min; // 做标记
                    }
                    cur = next;
                    next = cur + 1;
                    count = 0;
                }

            }
        }

        // 不需要搬运
        if(len == nums.length) {
            return len;
        }

        int now = 0;
        int start = 0;
        int end = 0;

        while(start < nums.length) {
            if(now == len) {
                break;
            }
            if(nums[start] == min) {
                // 搬运后面的
                if(end <= start) {
                    end = start + 1;
                }
                while(end < nums.length) {
                    if(nums[end] != min) {
                        nums[start] = nums[end];
                        nums[end] = min;
                        break;
                    }
                    end++;
                }
            }
            now++;
            start++;
        }

        return len;
    }
    */
}
