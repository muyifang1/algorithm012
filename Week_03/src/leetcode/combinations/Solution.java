package leetcode.combinations;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode #77
 * <p>
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author YangQi
 */
public class Solution {

    List<List<Integer>> resList = new LinkedList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {

        this.n = n;
        this.k = k;
        backTrack(1, new LinkedList<Integer>());
        return resList;
    }

    public void backTrack(int first, LinkedList<Integer> cur) {
        // terminator
        if (cur.size() == k) {
            System.out.println("resList.add(cur) cur.toString() = " + cur.toString());
            resList.add(new LinkedList<>(cur));
        }

        for (int i = first; i <= n; i++) {
            System.out.println("add i = " + i);
            cur.add(i);
            backTrack(i + 1, cur);
            System.out.println("i = " + i + " ; before removeLast() cur.toString() = " + cur.toString());
            cur.removeLast();
            System.out.println("after removeLast() cur.toString() = " + cur.toString());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.combine(3, 2);

        System.out.println("resList = " + solution.resList.toString());
    }
}
