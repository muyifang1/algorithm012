package leetcode.groupanagrams;

import java.util.*;

/**
 * leetcode #49
 * <p>
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author YangQi
 */
public class Solution2 {

    public List<List<String>> groupAnagrams(String[] strs) {

        // 思路：构建hashMap
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        for (String word : strs) {
            // hash算法生成key，字母出现次数作为key
            char[] cArray = word.toCharArray();
            Arrays.sort(cArray);
            String key = Arrays.toString(cArray);

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
        Solution2 solution = new Solution2();
        String[] strs = new String[]{"abb", "abc", "bba", "bab", "pro", "dog"};

        List<List<String>> resList = solution.groupAnagrams(strs);
        for (List<String> list : resList) {
            System.out.println("list.toString() = " + list.toString());
        }
    }
}
