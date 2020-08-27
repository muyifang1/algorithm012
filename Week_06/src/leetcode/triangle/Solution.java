package leetcode.triangle;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode #120
 * <p>
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author YangQi
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        // dp 方程 f[i,j] = Math.min(f[i+1,j]+f[i+1,j+1]) + a[i,j];

        int row = triangle.size();
        int[] minLength = new int[row + 1];

        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                minLength[i] = Math.min(minLength[i], minLength[i + 1]) + triangle.get(level).get(i);
            }
        }

        return minLength[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
/*
* [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
* */
        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> one = new LinkedList<>();
        one.add(2);
        List<Integer> two = new LinkedList<>();
        two.add(3);
        two.add(4);
        List<Integer> three = new LinkedList<>();
        three.add(6);
        three.add(5);
        three.add(7);
        List<Integer> four = new LinkedList<>();
        four.add(4);
        four.add(1);
        four.add(3);
        four.add(8);
        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
        triangle.add(four);

        System.out.println("solution = " + solution.minimumTotal(triangle));

        List.of();
    }
}
