package leetcode.uniquebinarysearchtreesii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * #leetcode #95
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author YangQi
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        // 递归
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> allTrees = new LinkedList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 循环可用根节点 当根节点为i ，所有左叶子节点 (start,i-1) , 所有右叶子节点(i+1,end)
        for (int i = start; i <= end; i++) {
            // 所有左子树
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // 所有右子树
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 遍历组合左右子树
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    allTrees.add(curr);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> resList = solution.generateTrees(3);

        for (TreeNode node : resList) {
            List<Integer> list = new LinkedList<>();
            System.out.println("res = " + Arrays.toString(solution.preOrderTravseral(node, list).toArray()));
            // solution.preOrderTravseral(node).toArray();
        }
    }

    public List<Integer> preOrderTravseral(TreeNode root, List<Integer> list) {

        if (root == null) {
            return new LinkedList<>();
        }

        list.add(root.val);
        preOrderTravseral(root.left, list);
        preOrderTravseral(root.right, list);
        return list;
    }
}
