package leetcode.jumparray;

/**
 * exmination jump array
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * @author YangQi
 */
public class Solution {

    public int jump(int[] nums) {

        int step = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length-1 ; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (i == end) {
                end = farthest;
                step++;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 0, 1};

        System.out.println("step = " + solution.jump(nums));
    }
}
