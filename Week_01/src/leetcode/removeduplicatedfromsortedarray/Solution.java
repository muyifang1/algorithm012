package leetcode.removeduplicatedfromsortedarray;

import java.util.Arrays;

/**
 * LeetCode #26
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author YangQi
 */
public class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0;
        int q = 1;

        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }

        return p + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 3};
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        int result = solution.removeDuplicates(nums);
        System.out.println("result = " + result);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));

        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }
}
