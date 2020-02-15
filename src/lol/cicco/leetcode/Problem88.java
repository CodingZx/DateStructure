package lol.cicco.leetcode;

public class Problem88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 原地归并
        int p1Idx = m - 1;
        int p2Idx = n - 1;

        int dataIdx = m + n - 1;

        while (p1Idx >= 0 && p2Idx >= 0) {
            if (nums1[p1Idx] > nums2[p2Idx]) {
                nums1[dataIdx] = nums1[p1Idx--];
            } else {
                nums1[dataIdx] = nums2[p2Idx--];
            }
            dataIdx--;
        }
        while (p2Idx >= 0) {
            nums1[dataIdx--] = nums2[p2Idx--];
        }
    }


    /*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        if(m == 0) {
            // 将nums2复制到nums1
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        for (int num : nums2) {
            int nowIdx = m - 1;
            while (nowIdx >= 0) { // 将所有元素后移..
                if (num >= nums1[nowIdx]) {
                    break;
                }
                nums1[nowIdx + 1] = nums1[nowIdx];
                nowIdx--;
            }

            nums1[nowIdx + 1] = num;
            m++;
        }
    }
    */
}
