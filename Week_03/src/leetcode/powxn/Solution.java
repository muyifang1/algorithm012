package leetcode.powxn;

/**
 * leetcode #50
 * <p>
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author YangQi
 */
public class Solution {

    public double myPow(double x, int n) {
        long N = n;
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        // terminator
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double res = fastPow(x, n / 2);
        // 判定 x 奇数偶数
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("solution.myPow(2, 3) = " + solution.myPow(2, -3));
    }
}
