package leetcode.narytreepreordertraversal;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    private List<Integer> list = new LinkedList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }

        list.add(root.val);

        for (Node child : root.children) {
            preorder(child);
        }

        return list;
    }
}
