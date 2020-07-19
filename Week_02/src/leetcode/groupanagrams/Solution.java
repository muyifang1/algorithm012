package leetcode.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode #49
 * <p>
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author YangQi
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        // 思路：构建HashMap，key=字母排序结果 value=单词
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // 字母异位词 hash() get key
        for (String word : strs) {
            int[] letterCounts = new int[26];
            for (int i = 0; i < word.length(); i++) {
                letterCounts[word.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < letterCounts.length; i++) {
                sb.append(letterCounts[i]);
            }
            String key = sb.toString();

            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new LinkedList<String>());
            }
            hashMap.get(key).add(word);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        int num = 0123;
        System.out.println("01123 = " + num);
// ["tao","pit","cam","aid","pro","dog"]
        Solution solution = new Solution();
        String[] strs = new String[]{"tao", "pit", "cam", "aid", "pro", "dog"};

        List<List<String>> resList = solution.groupAnagrams(strs);
        for (List<String> list : resList) {
            System.out.println("list.toString() = " + list.toString());
        }
    }
}
