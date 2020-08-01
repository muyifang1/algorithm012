package leetcode.binarytreelevelordertraversal;

import java.util.*;

/**
 * leetcode #102.二叉树的层遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 思路 ：BFS 广度优先搜索
 *
 * @author YangQi
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> allResults = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                results.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            allResults.add(results);
        }
        return allResults;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preOrder, inOrder);
        System.out.println("root = " + solution.levelOrder(root).toString());
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {

        int preLength = preOrder.length;
        int inLength = inOrder.length;
        // 先判断数据是否合法
        if (preLength != inLength) {
            throw new RuntimeException("Incorrect input data.");
        }

        // 循环中序遍历构建HashMap目的是能快速确认根节点下标 rootIndex
        // key= nodeVal, value = nodeIndex
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            hashMap.put(inOrder[i], i);
        }

        // 启动递归
        return myBuildTree(preOrder, 0, preLength - 1, inOrder, 0, inLength - 1, hashMap);
    }

    /**
     * 递归构建树
     *
     * @param preOrder 前序遍历数组
     * @param preStart 前序遍历数组起始下标
     * @param preEnd   前序遍历数组终止下标
     * @param inOrder  中序遍历数组
     * @param inStart  中序遍历数组起始下标
     * @param inEnd    中序遍历数组终止下标
     * @param hashMap  中序遍历值与下标对应关系
     * @return 树根节点
     */
    private TreeNode myBuildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, HashMap<Integer, Integer> hashMap) {
        // terminator
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // process logic
        // 构建根节点
        int rootVal = preOrder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 取得根节点在中序遍历中的位置 rootIndex
        int rootIndex = hashMap.get(rootVal);

        // drill down
        // 递归 构建root的左子树
        root.left = myBuildTree(preOrder, preStart + 1, rootIndex - inStart + preStart,
                inOrder, inStart, rootIndex - 1, hashMap);

        // 递归 构建root的右子树
        root.right = myBuildTree(preOrder, rootIndex - inStart + preStart + 1, preEnd,
                inOrder, rootIndex + 1, inEnd, hashMap);

        // reverse state
        return root;
    }
}
