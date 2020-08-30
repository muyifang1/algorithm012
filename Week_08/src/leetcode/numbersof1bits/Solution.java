package leetcode.numbersof1bits;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author YangQi
 */
public class Solution {

    /**
     * 汉明重量：
     * 数字中有多少个二进制 1
     */
    public int hamingWeight(int n) {
        int sum = 0;

        //思路 n&(n-1) 会把最后一个二进制 1 变成 0
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("solution.hamingWeight(2) = " + solution.hamingWeight(2));
        System.out.println("solution.hamingWeight(3) = " + solution.hamingWeight(3));
        System.out.println("solution.hamingWeight(4) = " + solution.hamingWeight(4));
        System.out.println("solution.hamingWeight(5) = " + solution.hamingWeight(5));
        System.out.println("solution.hamingWeight(6) = " + solution.hamingWeight(6));
        System.out.println("solution.hamingWeight(7) = " + solution.hamingWeight(7));
        System.out.println("solution.hamingWeight(8) = " + solution.hamingWeight(8));
    }
}
