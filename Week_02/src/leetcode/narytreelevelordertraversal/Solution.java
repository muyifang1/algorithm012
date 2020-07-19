package leetcode.narytreelevelordertraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode#429
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author YangQi
 */
public class Solution {
    private List<List<Integer>> res = new LinkedList<List<Integer>>();

    public List<List<Integer>> levelOrder(Node root) {
        // 如果入参为null
        if (root == null) {
            return res;
        }

        // 递归遍历每一层
        levelTraversal(root, 0);

        return res;
    }

    public void levelTraversal(Node node, int level) {
        // 每层一个List
        if (res.size() <= level) {
            // 当前层首个元素，创建List并 放入结果集中
            res.add(new ArrayList<>());
        }
        // 当前节点 放入结果集对应层中
        res.get(level).add(node.val);

        if (node.children == null) {
            return;
        }
        for (Node child : node.children) {
            levelTraversal(child, level + 1);
        }
    }

    public static void main(String[] args) {
        // Test
        List<Node> level3 = new LinkedList<Node>();
        level3.add(new Node(5));
        level3.add(new Node(6));

        List<Node> level2 = new LinkedList<Node>();
        level2.add(new Node(3, level3));
        level2.add(new Node(2));
        level2.add(new Node(4));
        Node root = new Node(1, level2);

        Solution solution = new Solution();
        List<List<Integer>> results = solution.levelOrder(root);

        for (List list : results) {
            System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        }
    }
}
