package leetcode.slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * #leedcode 239. 滑动窗口最大值
 */
public class Solution {

    // 思路:维护一个Deque，保存当前窗口最大值的数组位置，保证队列中数组位置的数值从大到小排序

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 剪枝优化，数组为空时 或者 只有一个元素 直接返回
        if (nums == null || nums.length < 2) {
            return nums;
        }

        // Deque 保存当前窗口最大值的数组位置，维护队列数组位置的数值 从大到小排序
        Deque<Integer> deque = new LinkedList();

        // 结果集
        int[] result = new int[nums.length - k + 1];

        // 遍历数组 nums
        for (int i = 0; i < nums.length; i++) {
            // 维护数组从大到小，如果前面数小则依次poll，直到满足条件
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 添加当前值对应的数组下标
            deque.addLast(i);

            // 判断当前队列中队首的值是否有效（是否滑出窗口）
            if (deque.peek() <= i - k) {
                deque.poll();
            }

            // 当前窗口长度为k时，result保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        // 返回结果集
        return result;
    }
}
