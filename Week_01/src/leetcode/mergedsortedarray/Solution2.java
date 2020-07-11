package leetcode.mergedsortedarray;

/**
 * 双指针从前往后
 */
public class Solution2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        // 两个指针分别指向两个数组
        int p = 0;
        int q = 0;
        // 最终目标数组指针
        int i = 0;
        // 循环比较
        while (p < m && q < n) {
            if (nums1_copy[p] < nums2[q]) {
                nums1[i] = nums1_copy[p];
                p++;
            } else {
                nums1[i] = nums2[q];
                q++;
            }
            i++;
        }
        // 如果队尾还有剩余元素
        if (p < m) {
            System.arraycopy(nums1_copy, p, nums1, p + q, m + n - p - q);
        }
        if (q < n) {
            System.arraycopy(nums2, q, nums1, p + q, m + n - p - q);
        }
    }
}
