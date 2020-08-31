package leetcode.reversebits;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 *
 * @author YangQi
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;

        // 将给定二进制由低到高取出，移位，再组合
        for (int i = 0; i < 32; i++) {

            // 取出第i位
            int temp = (n >> i) & 1;
            // 移位
            temp = temp << (31 - i);
            // 组合结果
            result |= temp;
        }

        return result;
    }

    public void binaryToDecimal(int n) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(n >>> i & 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.binaryToDecimal(3);

        int res = solution.reverseBits(3);
        System.out.println("\nsolution.reverseBits(3) = " + res);
        solution.binaryToDecimal(res);

        System.out.println("");
        int test = 4;
        System.out.println("(1 << 4) - 1 二进制表示");
        solution.binaryToDecimal((1 << test) - 1);

        System.out.println("");
        test = 5;
        System.out.println("(1 << 5) 二进制表示");
        solution.binaryToDecimal((1 << test));
        System.out.println("");
        System.out.println("(1 << 5) - 1 二进制表示");
        solution.binaryToDecimal((1 << test) - 1);
    }
}
