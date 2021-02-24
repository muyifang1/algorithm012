package leetcode.validatebinarysearchtree;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * #leetcode 98. 验证二叉搜索树
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {

        // 思路：递归判断

        return helper(root, null, null);
    }

    /**
     * 递归判断
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {

        // terminator
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        // process current logic

        // drill down
        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }

        return true;
        // restore current status
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
