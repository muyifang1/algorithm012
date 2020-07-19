package leetcode.unibinarysearchtree;

/**
 * leetcode #96
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author YangQi
 */
public class Solution {

    public int numTrees(int n) {

        /**
         * G[0] = 1
         * G[1] = 1
         * G[2] = G[0]*G[1]
         * G[i] += G[i-2]*G[i-1]
         * */
        int[] G = new int[n + 1];

        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
