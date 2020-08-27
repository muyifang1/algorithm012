package leetcode.validsudoku;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @author YangQi
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {

        // 行，列，九宫格，默认值0，列长10目的是为了能有9;
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        // 循环遍历81个单元格
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 如果未填数字则继续
                if (board[i][j] == '.') {
                    continue;
                }
                // 剪枝
                int curr = board[i][j] - '0';
                if (row[i][curr] == 1) {
                    return false;
                }
                if (col[j][curr] == 1) {
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][curr] == 1) {
                    return false;
                }

                // 第一次出现把该单元格赋值 1
                row[i][curr] = 1;
                col[j][curr] = 1;
                box[j / 3 + (i / 3) * 3][curr] = 1;
            }
        }

        return true;
    }

}
