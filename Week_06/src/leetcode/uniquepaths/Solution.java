package leetcode.uniquepaths;

/**
 * leetcode #62 不同路径
 * <p>
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author YangQi
 */
public class Solution {

    public int uniquePaths(int m, int n) {

        //  [
        //    [0,0,0],
        //    [0,0,0],
        //    [0,0,0]
        //  ]
        // 递推公式 dp[x][y]=dp[x-1][y]+dp[x][y-1]
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
