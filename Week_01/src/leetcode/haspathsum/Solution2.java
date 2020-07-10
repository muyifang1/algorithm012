package leetcode.haspathsum;

public class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 递归
        if (root == null) {
            return false;
        }
        // 子节点 判定结果 递归返回
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
