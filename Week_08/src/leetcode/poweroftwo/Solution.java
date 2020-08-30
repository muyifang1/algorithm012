package leetcode.poweroftwo;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 *
 * @author YangQi
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        // -2147483648 特殊testcase
        // return (n != 0) && ((n & (n - 1)) == 0);

        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("0 isPowerofTwo  = " + solution.isPowerOfTwo(0));
        System.out.println("2 isPowerofTwo  = " + solution.isPowerOfTwo(2));
        System.out.println("3 isPowerofTwo  = " + solution.isPowerOfTwo(3));
        System.out.println("-4 isPowerofTwo  = " + solution.isPowerOfTwo(-4));

        // -2147483648 特殊testcase
        System.out.println("-2147483648 isPowerofTwo  = " + solution.isPowerOfTwo(-2147483648));
    }
}
