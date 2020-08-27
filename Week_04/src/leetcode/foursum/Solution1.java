package leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * exmination 4 sum
 * <p>
 * 判断是否存在 a + b + c + d = target
 * 输出并去重
 *
 * @author YangQi
 */
public class Solution1 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4)
            return lists;
        int a, b, c, d;
        for (a = 0; a <= nums.length - 4; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (b = a + 1; b <= nums.length - 3; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target)
                        c++;
                    else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        lists.add(list);
                        while (c < d && nums[c + 1] == nums[c])      //确保nums[c] 改变了
                            c++;
                        while (c < d && nums[d - 1] == nums[d])      //确保nums[d] 改变了
                            d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
//[-1,0,1,2,-1,-4]
//-1
        int[] numbs = new int[]{0, 0, 0, 0};
        int target = 0;

        System.out.println("fourSum result = " + solution.fourSum(numbs, target).toString());
    }
}
