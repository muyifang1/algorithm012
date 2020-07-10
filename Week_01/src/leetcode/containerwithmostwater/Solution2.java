package leetcode.containerwithmostwater;

public class Solution2 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // 取得最小高度
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            // 计算面积
            maxArea = Math.max(maxArea, minHeight * (right - left + 1));
        }

        return maxArea;
    }
}
