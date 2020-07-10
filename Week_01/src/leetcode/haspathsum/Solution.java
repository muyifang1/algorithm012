package leetcode.haspathsum;

/**
 * LeetCode #112 haspathSum 路径总和 https://leetcode-cn.com/problems/path-sum/
 * <p>
 * java 递归解法 recursion
 *
 * @author yanqqi
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        // 判断节点是否为空
        if (root == null) {
            return false;
        }
        // 递归退出结果：叶子结点值等于剩余值
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        // 递归，入参是子节点和 总和减去路径值
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Solution3 solution = new Solution3();

        System.out.println(solution.hasPathSum(root, 22));
    }
}
