package leetcode.twosumlistsorted;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode #167
 * <p>
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author YangQi
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        // 思路：循环,构建HashMap其中 key=target-num, value = i;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                res[0] = hashMap.get(nums[i]) + 1;
                res[1] = i + 1;
                break;
            }
            hashMap.put(target - nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test case
        int[] arr = {2, 7, 11, 15};
        System.out.println("result = " + Arrays.toString(solution.twoSum(arr, 13)));
    }
}
