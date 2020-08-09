package leetcode.findlargesteachrow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode #515 在每个树行中找最大值
 * <p>
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * @author YangQi
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return resList;
        }
        // 思路：BFS逐行遍历，取得最大值
        queue.add(root);

        while (!queue.isEmpty()) {

            int max = Integer.MIN_VALUE;
            int size = queue.size();
            // 逐行寻找最大值
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            resList.add(max);
        }

        return resList;
    }
}
