package leetcode.mergedsortedarray;

import java.util.Arrays;

/**
 * LeetCode #88
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author YangQi
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {

        int[] nums1 = new int[8];
        int[] nums2 = new int[5];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;

        nums2[0] = 2;
        nums2[1] = 4;
        nums2[2] = 6;
        nums2[3] = 7;
        nums2[4] = 8;

        System.out.println("original nums1 = " + Arrays.toString(nums1));
        System.out.println("original nums2 = " + Arrays.toString(nums2));
        Solution3 solution = new Solution3();
        solution.merge(nums1, 3, nums2, 5);

        System.out.println("result = " + Arrays.toString(nums1));
    }
}
