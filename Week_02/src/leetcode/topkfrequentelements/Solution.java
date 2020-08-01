package leetcode.topkfrequentelements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * leetcode #347
 * <p>
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author YangQi
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();

        // 构建HashMap记录出现 所有元素出现频率，时间复杂度 O(n)
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 构建大顶堆，来存储hashmap元素，假设hashmap中有k个元素 时间复杂度 O(logK)
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int key : count.keySet()) {
            heap.offer(key);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test case
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};

        System.out.println("solution = " + Arrays.toString(solution.topKFrequent(arr, 2)));
        // System.out.println("solution = " + Arrays.toString(solution.topKFrequent(arr, 2).toArray()));
    }
}
