package leetcode.foursum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * exmination 4 sum
 * <p>
 * 判断是否存在 a + b + c + d = target
 * 输出并去重
 *
 * @author YangQi
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resList = new LinkedList<>();
        // 优化
        if (nums == null && nums.length < 4) {
            return resList;
        }

        // 排序，目的为了优化判定
        Arrays.sort(nums);
        // 思路： 四个指针 i,j,k,l 在数组中循环判定
        int i, j, k, l;
        // 初始指针 i=0; j=i+1; k=j+1; l=nums.length-1;
        for (i = 0; i < nums.length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 优化
            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                System.out.println("min1 break = " + nums[i] + "," + nums[i + 1] + "," + nums[i + 2] + "," + nums[i + 3]);
                break;
            }

            // 确定第二个数
            for (j = i + 1; j < nums.length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 优化
                int min2 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min2 > target) {
                    // System.out.println("min2 break = " + nums[i] + "," + nums[j] + "," + nums[j + 1] + "," + nums[j + 2]);
                    break;
                }

                // 确定最后两个数
                k = j + 1;
                l = nums.length - 1;
                // 双指针向中间收敛查找
                while (k < l) {
                    int sumResult = nums[i] + nums[j] + nums[k] + nums[l];
                    // 结果匹配
                    if (sumResult == target) {
                        resList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // 去重
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        // 向中间收敛
                        k++;
                        l--;
                    } else if (sumResult > target) {
                        // 结果值大于目标，右边界向左移动
                        l--;
                    } else {
                        // 结果小于目标，左边界向右移动
                        k++;
                    }
                }
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//[-1,0,1,2,-1,-4]
//-1

        //[0,4,-5,2,-2,4,2,-1,4]
        //12
        int[] numbs = new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4};
        int target = 12;

        System.out.println("fourSum result = " + solution.fourSum(numbs, target).toString());
    }
}
