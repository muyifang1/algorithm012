package leetcode.mergedsortedarray;

/**
 * 双指针从后向前
 */
public class Solution3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针,从后向前
        int p = m - 1;
        int q = n - 1;
        // 目标指针
        int i = m + n - 1;

        while (p >= 0 && q >= 0) {
            nums1[i--] = nums1[p] > nums2[q] ? nums1[p--] : nums2[q--];
        }

        System.arraycopy(nums2, 0, nums1, 0, q + 1);
    }
}
