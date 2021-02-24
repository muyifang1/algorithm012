package leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * #leetcode 15 三数之和
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        // 思路：先从小到大排序，然后循环固定一个值，双指针循环查找另外两个值(双指针向中间收敛)

        int n = nums.length;
        // 排序
        Arrays.sort(nums);
        // 结果集
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // 枚举a
        for (int first = 0; first < n; first++) {
            // 剪枝 排重
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            // 确定c对应指针初始指向数组的最右端
            int third = n - 1;
            // b+c = -a
            int target = -nums[first];

            // 枚举b
            for (int second = first + 1; second < n; second++) {
                // 剪枝 排重
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 确定b在c左侧，c逐步左移
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }

                // 避免b与c重合
                if (second == third) {
                    break;
                }

                // 满足条件数据保存到结果集
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }

        return result;
    }

}
