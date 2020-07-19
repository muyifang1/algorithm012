package leetcode.validanagram;

/**
 * Hash解题思路
 */
public class Solution1 {

    public boolean isAnagram(String s, String t) {
        // 根据长度直接判断
        if (s.length() != t.length()) {
            return false;
        }

        // 初始化一个数组记录26个字母出现次数
        int[] counter = new int[26];
        // s按位++，t按位--
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        // 循环判定结果，如果counter数组内容都是0 则相同
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        // 输出
        return true;
    }
}
