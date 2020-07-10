package leetcode.respacelcci;

public class Solution2 {

    class TrieNode {
        TrieNode[] childs;
        boolean isWord;

        public TrieNode() {
            childs = new TrieNode[26];
            isWord = false;
        }
    }

    // 全局变量，字典树用于存储dictionary
    TrieNode root;

    public int respace(String[] dictionary, String sentence) {
        root = new TrieNode();
        // 创建字典树
        makeTrie(dictionary);
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = n - i;
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int c = sentence.charAt(j) - 'a';
                if (node.childs[c] == null) {
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j + 1]);
                    break;
                }
                if (node.childs[c].isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                } else {
                    dp[i] = Math.min(dp[i], j - i + 1 + dp[j + 1]);
                }
                node = node.childs[c];
            }
        }
        return dp[0];
    }

    /*
     * 把dictionary存入全局变量root中
     */
    public void makeTrie(String[] dictionary) {

        for (String str : dictionary) {
            // 根节点是统一的空白节点
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                // 把字符串转换成数字
                int j = str.charAt(i) - 'a';
                // 值放入对应节点
                if (node.childs[j] == null) {
                    node.childs[j] = new TrieNode();
                }
                node = node.childs[j];
            }
            // 单词结尾
            node.isWord = true;
        }
    }
}
