package leetcode.containerwithmostwater;

/**
 * LeetCode #11 container-with-most-water
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author YangQi
 */
public class Solution {

    public int maxArea(int[] height) {
        int area = 0;
        // i 左边界，j 右边界
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (i == j) {
                break;
            }
            // 面积 = 最短值*距离差
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));

            // 选择短板向中间收敛
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("solution.maxArea(height) = " + solution.maxArea(height));
    }
}
