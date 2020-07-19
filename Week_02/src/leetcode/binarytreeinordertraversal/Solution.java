package leetcode.binarytreeinordertraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode #94
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author YangQi
 */
public class Solution {
    private List<Integer> list = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode node) {
        if (node == null) {
            return list;
        }

        inorderTraversal(node.left);
        list.add(node.val);
        inorderTraversal(node.right);

        return list;
    }
}
