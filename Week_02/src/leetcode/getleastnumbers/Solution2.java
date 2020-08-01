package leetcode.getleastnumbers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 思路 大根堆 用 PriorityQueue
 */
public class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k >= arr.length) {
            return arr;
        }

        // 构建一个大根堆
        Queue<Integer> que = new PriorityQueue<>((v1, v2) -> v2 - v1);

        for (int i : arr) {
            // 如果堆中元素少于k，则add进大根堆中
            if (que.size() < k) {
                que.offer(i);
            } else {
                // i与堆根比较
                if (i > que.peek()) {
                    continue;
                } else {
                    que.poll();
                    que.offer(i);
                }
            }
        }

        int[] resArray = new int[k];
        int index = 0;
        for (int num : que) {
            resArray[index++] = num;
        }

        return resArray;
    }
}
