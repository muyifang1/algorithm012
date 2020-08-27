package leetcode.trieprefixtree;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
 *
 * @author YangQi
 */
public class Trie {

    private boolean isEnd = false;
    private Trie[] next;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        isEnd = false;
        // 26字母
        next = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 判定word是否为空
        if (word == null || word.length() == 0) {
            return;
        }

        Trie curr = this;
        // word拆分成字符串
        char[] chars = word.toCharArray();
        // 循环字符串生成Trie树
        for (char c : chars) {
            int n = c - 'a';

            if (curr.next[n] == null) {
                curr.next[n] = new Trie();
            }
            curr = curr.next[n];
        }
        // 结束
        curr.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        // word转换成字符串
        char[] chars = word.toCharArray();
        // 循环
        for (char c : chars) {
            node = node.next[c - 'a'];
            if (node == null) {
                return null;
            }
        }

        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("trie.search(\"apple\") = " + trie.search("apple"));
        System.out.println("trie.search(\"app\") = " + trie.search("app"));
        System.out.println("trie.startsWith(\"app\") = " + trie.startsWith("app"));
        trie.insert("app");
        System.out.println("trie.search(\"app\") = " + trie.search("app"));
    }
}
