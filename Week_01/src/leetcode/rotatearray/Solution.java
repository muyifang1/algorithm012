package leetcode.rotatearray;

import java.util.Arrays;

/**
 * LeetCode #189 旋转数组
 * <p>
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author YangQi
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        // 全反转
        reverse(nums, 0, nums.length - 1);
        // 反转k前部分
        reverse(nums, 0, k - 1);
        // 反转k后部分
        reverse(nums, k, nums.length - 1);
    }

    public int[] reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp;

            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("original nums = " + Arrays.toString(nums));
        //   solution.reverse(nums, 0, 6);
        //   System.out.println("reverse nums 1 to 4= " + Arrays.toString(nums));
        //   solution.reverse(nums, 4, 6);
        //   System.out.println("reverse nums 4 to 6= " + Arrays.toString(nums));
        solution.rotate(nums, 8);
        System.out.println("Result nums = " + Arrays.toString(nums));
    }
}
