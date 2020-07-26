package leetcode.generateparentheses;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode #22
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author YangQi
 */
public class Solution {

    private List<String> resList = new LinkedList<>();

    public List<String> generateParentheses(int n) {
        generateParent(0, 0, n, "");
        return resList;
    }

    private void generateParent(int left, int right, int n, String str) {

        // terminator
        if (left == n && right == n) {
            resList.add(str);
            return;
        }

        // process logic

        // drill down
        if (left < n) {
            generateParent(left + 1, right, n, str + "(");
        }

        if (left > right) {
            generateParent(left, right + 1, n, str + ")");
        }
        // reverse states
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result = " + Arrays.toString(solution.generateParentheses(1).toArray()));
    }
}
