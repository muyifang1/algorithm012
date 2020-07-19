package leetcode.validanagram;

import java.util.Arrays;

/**
 * leetcode #242
 * <p>
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author YangQi
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        // String转化成char数组
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        // char数组排序
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        // 比较排序后数组
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println("(anagram,nagaram) result = " + solution.isAnagram("anagram", "nagaram"));
        System.out.println("(car,cat) result = " + solution.isAnagram("car", "cat"));

        System.out.println("\"a\".charAt(0) = " + "a".charAt(0));
        System.out.println("\"b\".charAt(0) = " + "b".charAt(0));
        System.out.println("\"b-a\".charAt(0) = " + ("ab".charAt(1) - "ab".charAt(0)));
    }
}
