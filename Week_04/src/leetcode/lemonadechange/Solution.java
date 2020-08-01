package leetcode.lemonadechange;

/**
 * #leetcode #860
 * <p>
 * https://leetcode-cn.com/problems/lemonade-change/description/
 *
 * @author YangQi
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int fiveSum = 0;
        int tenSum = 0;
        int twentySum = 0;

        for (int bill : bills) {
            // 5
            if (bill == 5) {
                fiveSum++;
            } else if (bill == 10) {
                if (fiveSum == 0) {
                    return false;
                }
                // 10
                tenSum++;
                fiveSum--;
            } else {
                // 20
                // 手里有5也有10
                if (fiveSum > 0 && tenSum > 0) {
                    fiveSum--;
                    tenSum--;
                } else if (fiveSum >= 3) {
                    // 手里只有5
                    fiveSum -= 3;
                } else {
                    // 找不开
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bills = {5, 5, 5, 5, 10, 5, 10, 10, 10, 20};

        System.out.println("bills = " + solution.lemonadeChange(bills));
    }
}
