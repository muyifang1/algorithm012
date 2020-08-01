package leetcode.assigncookies;

import java.util.Arrays;

/**
 * leetcode 455.分发饼干
 * <p>
 * https://leetcode-cn.com/problems/assign-cookies/
 *
 * @author YangQi
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int i = 0;
        int j = 0;

        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            }
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {1, 2, 3};
        int[] s = {2, 3};
        System.out.println("solution.findContentChildren() = " + solution.findContentChildren(g, s));
    }
}
