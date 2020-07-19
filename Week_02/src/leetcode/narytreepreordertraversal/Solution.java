package leetcode.narytreepreordertraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode #589
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * @author YangQi
 */
public class Solution {
    // N岔树 前序遍历
    private List<Integer> result;

    public List<Integer> preorder(Node root) {
        result = new LinkedList<Integer>();
        // 递归前序遍历
        preOrderTree(root);

        return result;
    }

    public void preOrderTree(Node root) {
        if (root == null) {
            return;
        }
        result.add(root.val);

        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            preOrderTree(child);
        }
    }
}
