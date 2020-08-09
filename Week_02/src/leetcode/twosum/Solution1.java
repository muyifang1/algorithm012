package leetcode.twosum;

import java.util.Arrays;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sumVal = nums[start] + nums[end];

            if (sumVal == target) {
                return new int[]{start, end};
            } else if (sumVal < target) {
                start++;
            } else {
                end--;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] nums = {1, 2, 3, 4};
        int target = 6;

        System.out.println("result = " + Arrays.toString(solution1.twoSum(nums, target)));
    }
}
