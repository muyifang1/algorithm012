package leetcode.maximumsubarray;

/**
 * leetcode #53
 * https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author YangQi
 */
public class Solution {
    public int maxSubArray(int[] nums) {

        // 分治 子问题 problem[i] = Math.max(subProblem[i-1],0) + a[i];
        // 状态数组 f[i]
        // dp方程 f[i] = Math.max(f[i-1],0) + a[i];

        // 优化
        if (nums == null) {
            return 0;
        }

        int subResult = nums[0]; // sub problem result
        int result = subResult;

        for (int i = 1; i < nums.length; i++) {
            subResult = Math.max(nums[i], subResult + nums[i]);
            // 直接统计最大值
            result = Math.max(result, subResult);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("solution.maxSubArray() = " + solution.maxSubArray(nums));
    }
}
