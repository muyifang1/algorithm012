package leetcode.minimumpathsum;

/**
 * #leetcode #64
 * <p>
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author YangQi
 */
public class Solution {

    public int miniPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // 初始位置
                if (i == 0 && j == 0) {
                    continue;
                }
                // 左侧边界
                else if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                // 右侧边界
                else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    // 未在边界，取最小值累加
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println("solution.miniPathSum(grid) = " + solution.miniPathSum(grid));
    }
}
