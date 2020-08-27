package leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resList = new ArrayList<>();

        // 优化
        if (nums.length < 4) {
            return resList;
        }

        // 排序
        Arrays.sort(nums);

        // 思路，4指针向中间收敛
        // int i=0; // 首指针
        // int j=i+1; // 第二个指针
        // int k=j+1; // 第三个指针
        // int l=nums.length-1; // 尾指针

        // 满足条件 target = nums[i]+nums[j]+nums[k]+nums[l]

        // 首指针循环
        for (int i = 0; i < nums.length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 第二个指针循环
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    // 满足条件 target = nums[i]+nums[j]+nums[k]+nums[l]
                    if (target == nums[i] + nums[j] + nums[k] + nums[l]) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[l]);
                        resList.add(result);

                        // 去重
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        k++;
                        l--;
                    } else if (target > nums[i] + nums[j] + nums[k] + nums[l]) {
                        // sumResult < target
                        k++;
                    } else {
                        // sumResult > target
                        l--;
                    }
                }

            }
        }

        return resList;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//[-1,0,1,2,-1,-4]
//-1

        //[0,4,-5,2,-2,4,2,-1,4]
        //12
        int[] numbs = new int[]{0, 0, 0, 0};
        int target = 0;

        System.out.println("fourSum result = " + solution.fourSum(numbs, target).toString());
    }
}
