package leetcode.getleastnumbers;

import java.util.Arrays;

/**
 * leetcode 剑指 Offer 40. 最小的k个数
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author YangQi
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        // 暴力解法：排序，取前k元素
        Arrays.sort(arr);

        int[] resArr = new int[k];

        for (int i = 0; i < k; i++) {
            resArr[i] = arr[i];
        }

        return resArr;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] arr = {2, 3, 6, 1, 0, 7, 8};
        System.out.println("get Least numbers result = " + Arrays.toString(solution.getLeastNumbers(arr, 4)));
    }
}
