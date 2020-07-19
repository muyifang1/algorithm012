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
public class Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {

        // 思路：构建hashMap
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        for (String word : strs) {
            // hash算法生成key，字母出现次数作为key
            int[] lettersCount = new int[26];
            for (char c : word.toCharArray()) {
                lettersCount[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < lettersCount.length; i++) {
                sb.append(lettersCount[i]);
            }

            String key = sb.toString();

            // 根据key分组
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
        Solution1 solution = new Solution1();
        String[] strs = new String[]{"tao", "pit", "cam", "aid", "pro", "dog"};

        List<List<String>> resList = solution.groupAnagrams(strs);
        for (List<String> list : resList) {
            System.out.println("list.toString() = " + list.toString());
        }
    }
}
