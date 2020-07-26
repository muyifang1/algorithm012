package leetcode.lowestcommonancestor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode #236 todo
 * <p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author YangQi
 */
public class Solution {
    // 思路，深度优先遍历 构造一个HashMap 用来存储父节点
    // key = nodeValue ; value = parentNode
    HashMap<Integer, TreeNode> parentHashMap = new HashMap<>();
    // 用Set来记录是否遍历过
    Set<Integer> visitedSet = new HashSet<>();

    public void dfs(TreeNode root) {

        if (root.left != null) {
            parentHashMap.put(root.left.val, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parentHashMap.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 构建父节点HashMap
        dfs(root);

        // 从p开始遍历向上父节点
        while (p != null) {
            visitedSet.add(p.val);
            p = parentHashMap.get(p.val);
        }

        // 从q开始遍历向上父节点，并判断是否与p父节点重合
        while (q != null) {
            // 如果重合，则q就是最近祖父节点
            if (visitedSet.contains(q.val)) {
                return q;
            }
            q = parentHashMap.get(q.val);
        }
        // p和q 没有共同祖父节点
        return null;
    }
}
