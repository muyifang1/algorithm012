package leetcode.divingboard;

import java.util.Arrays;

/**
 * Leetcode 面试题16.11.跳水板
 * <p>
 * https://leetcode-cn.com/problems/diving-board-lcci/
 *
 * @author YangQi
 */
public class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
        // k为0 的情况
        if (k == 0) {
            return new int[]{};
        }

        // shorter等于longer的情况，返回结果只有一个 k*shorter
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        // 其他情况(shorter不等于longer且k不等于0),返回结果是一个longer-shorter的等差数列
        // 循环计算等差数列，并返回
        int[] result = new int[k + 1];
        // 注意这里 i <= k, 有一种可能全部是 短板，或者全部是长版
        for (int i = 0; i <= k; i++) {
            result[i] = shorter * (k - i) + longer * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.divingBoard(1, 2, 3)));
    }
}
