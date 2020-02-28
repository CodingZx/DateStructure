package lol.cicco.leetcode;

public class Problem04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return getMiddle(nums2);
        }
        if (nums2.length == 0) {
            return getMiddle(nums1);
        }

        int[] arr = new int[nums1.length + nums2.length];
        int nowIdx = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        while(leftIdx < nums1.length || rightIdx < nums2.length) {
            if(leftIdx >= nums1.length) {
                arr[nowIdx++] = nums2[rightIdx++];
                continue;
            }
            if(rightIdx >= nums2.length) {
                arr[nowIdx++] = nums1[leftIdx++];
                continue;
            }
            if(nums1[leftIdx] > nums2[rightIdx]) {
                arr[nowIdx++] = nums2[rightIdx++];
            } else {
                arr[nowIdx++] = nums1[leftIdx++];
            }
        }
        return getMiddle(arr);
    }

    private double getMiddle(int[] arr) {
        if (arr.length % 2 == 0) {
            // 偶数
            return ((double) arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

}
