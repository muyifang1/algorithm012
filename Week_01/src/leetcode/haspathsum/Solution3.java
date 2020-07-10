package leetcode.haspathsum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索 BFS Breadth First Search
 *
 * @author YangQi
 */
public class Solution3 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // 两个队列分别存放 nodes 和 val累加结果
        Queue<TreeNode> queNodes = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNodes.offer(root);
        queVal.offer(root.val);

        // 循环队列 如果是根节点，判断sum结果 并返回
        while (!queNodes.isEmpty()) {
            TreeNode current = queNodes.poll();
            int tmp = queVal.poll();
            if (current.left == null && current.right == null) {
                if (tmp == sum) {
                    return true;
                }
                continue;
            }

            // 如果有左节点 push进队列
            if (current.left != null) {
                queNodes.offer(current.left);
                queVal.offer(current.left.val + tmp);
            }

            // 如果有右节点 push进队列
            if (current.right != null) {
                queNodes.offer(current.right);
                queVal.offer(current.right.val + tmp);
            }
        }
        return false;
    }
}
