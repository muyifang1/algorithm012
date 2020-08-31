package leetcode.nqueens;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * <p>
 * 位运算题解
 *
 * @author YangQi
 */
public class Solution {

    private int size = 0;
    private int count = 0;

    public int totalNQueens(int n) {
        // 1左移n位减1，例：n=4,结果是 1111
        size = (1 << n) - 1;
        solveDFS(0, 0, 0);
        return count;
    }

    public void solveDFS(int row, int pie, int na) {
        // terminator
        if (row == size) {
            count++;
            return;
        }

        // process logic
        // 当前层能放queen的所有位置
        int pos = size & (~(row | pie | na));

        while (pos != 0) {
            int p = pos & (-pos);
            // 当前p位置放上queen
            pos = pos - p;
            // drill down
            solveDFS(row | p, (pie | p) << 1, (na | p) >> 1);
        }
        // reverse states
    }
}
