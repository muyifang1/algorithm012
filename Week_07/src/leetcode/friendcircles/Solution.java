package leetcode.friendcircles;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 * <p>
 * 并查集
 *
 * @author YangQi
 */
public class Solution {
    int[] parent = new int[200];

    public int find(int x) {
        /*
        if (parent[x] == x) {
            return x;
        }
        // 压缩路径
        return parent[x] = find(parent[x]);
        */
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            // 压缩路径
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            parent[fx] = fy;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        // 初始化 并查集 parent[i]
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 统计父节点数
        int res = 0;
        for (int i = 0; i < n; i++) {
            //如果parent[i] = i，则说明i就是一个父节点
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }
}
