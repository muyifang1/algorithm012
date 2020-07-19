package leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode #1
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author YangQi
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 循环入hashmap
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];

            if (hashMap.containsKey(nums[i])) {
                return new int[]{hashMap.get(nums[i]), i};
            }

            hashMap.put(value, i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbs = new int[]{2, 7, 0, 1};
        int target = 9;
        String result = Arrays.toString(solution.twoSum(numbs, target));
        System.out.println("result = " + result);
    }
}
