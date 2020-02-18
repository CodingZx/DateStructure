package lol.cicco.leetcode;

public class Problem41 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int val = nums[i];
            // 超出界限直接丢掉 缺少的正整数肯定在这以内
            if(val > nums.length) {
                nums[i] = -nums[i];
                i++;
                continue;
            }
            // 小于0直接丢掉 缺少正整数最小值为-1
            if(val <= 0) {
                nums[i] = -1;
                i++;
                continue;
            }
            // 已经交换过 或者当前位置标记已经正确的 跳过
            if(val == i + 1) {
                i++;
                continue;
            }

            // 剩余 1 至 length 区间
            int swap = nums[val - 1];
            // 防止重复处理... 对应坐标数值与当前要处理的数值相同 表示已经处理过  丢掉便可
            if(swap == val) {
                nums[i] = -1;
                i++;
                continue;
            }
            // 交换位置 将目标索引位置-1设置好标记
            nums[val - 1] = val;
            nums[i] = swap;
        }

        // 按照索引判断即可.
        // 前面一个循环已经把非法数据全部设置为负数
        // 并将可能的数字放到对应索引上
        // 只要对应索引上某个数据为负数  则 一定为缺失的最小正整数
        for(int i=0;i<nums.length;i++) {
            if(nums[i] <= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
