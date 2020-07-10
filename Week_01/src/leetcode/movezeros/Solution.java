package leetcode.movezeros;

import java.util.Arrays;

/**
 * Leetcode #283 https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author YangQi
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 非零数据 传递给j元素， i元素保存0
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();

        int[] array = { 0, 2, 7, 0, 3, 9, 0 };

        System.out.println("original :" + Arrays.toString(array));

        solution2.moveZeroes(array);

        System.out.println("after :" + Arrays.toString(array));
    }
}
