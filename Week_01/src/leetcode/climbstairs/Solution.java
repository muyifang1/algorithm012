package leetcode.climbstairs;

/**
 * LeetCode #70 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author YangQi
 */
public class Solution {
    public int climbStair(int n) {

        if (n == 0) {
            return 1;
        }

        // 动态规划,用数组dp[n+1]记录状态
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result = " + solution.climbStair(0));
    }
}
