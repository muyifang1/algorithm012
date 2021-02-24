package leetcode.kthlargestelementinastream;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * leetcode #703 数据流中的第 K 大元素
 */
public class KthLargest {

    // 思路：使用优先队列PriorityQueue 维护一个元素为K的小顶堆

    // 优先队列
    final PriorityQueue<Integer> priorityQueue;
    // 元素k
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // 创建一个优先队列
        priorityQueue = new PriorityQueue<>(k);
        // 循环add nums
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        // 如果队列元素不足k，追加元素
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            // 如果堆顶值小于 val 则淘汰堆顶值，并插入val
            priorityQueue.poll();
            priorityQueue.offer(val);
        }

        // 返回小顶堆的最小值
        return priorityQueue.peek();
    }
}
