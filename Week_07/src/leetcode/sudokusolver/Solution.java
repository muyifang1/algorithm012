package leetcode.sudokusolver;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * @author YangQi
 */
public class Solution {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    // 递归，剪枝
    public boolean solve(char[][] board) {

        // 循环遍历，递归回溯
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {
                    // 尝试填入1~9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            // 如果递归成功返回true
                            if (solve(board)) {
                                return true;
                            } else {
                                // 否则退回原状态，回溯
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // 校验数独正确性
    private boolean isValid(char[][] board, int row, int col, char c) {
        // 循环遍历81个单元格，判定行，列，box 是否合法
        for (int i = 0; i < 9; i++) {
            // 行剪枝
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            // 列剪枝
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            // box剪枝
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("9 % 3 = " + 9 % 3);
    }
}
