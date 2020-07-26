package leetcode.climbstairs;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 递归思路 + 缓存
 *
 * @author YangQi
 */
public class Solution1 {
    // 用hashmap记录重复的递归结果
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            hashMap.put(1, 1);
            return 1;
        }

        if (n == 2) {
            hashMap.put(2, 2);
            return 2;
        }

        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        System.out.println("result = " + solution.climbStairs(44));
    }
}
