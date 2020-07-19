package leetcode.interleavingstring;

import java.util.LinkedList;

/**
 * leetcode #97
 * <p>
 * https://leetcode-cn.com/problems/interleaving-string/
 * 解题思路错误 NG todo need try again
 *
 * @author YangQi
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // 思路 构造一个s1和s2的交叉字符串，与 s3对比
        LinkedList<String> listStr1 = mergeChar(s1.toCharArray());
        LinkedList<String> listStr2 = mergeChar(s2.toCharArray());

        StringBuilder sb = new StringBuilder();
        int minSize = Math.min(listStr1.size(), listStr2.size());
        for (int i = 0; i < minSize; i++) {
            sb.append(listStr1.poll());
            sb.append(listStr2.poll());
        }

        if (!listStr1.isEmpty()) {
            for (String str : listStr1) {
                sb.append(str);
            }
        }

        if (!listStr2.isEmpty()) {
            for (String str : listStr2) {
                sb.append(str);
            }
        }
        System.out.println("sb.toString() = " + sb.toString());
        return sb.toString().equals(s3);
    }

    /**
     * a,
     * a,aa
     * a,aaa
     * b,aaa,b
     * b,aaa,bb
     * c,aaa,bb,c
     */
    public LinkedList<String> mergeChar(char[] cArray) {
        LinkedList<String> resList = new LinkedList<String>();

        for (int i = 0; i < cArray.length; i++) {
            // 首次进入循环
            if (i == 0) {
                resList.offer(String.valueOf(cArray[i]));
                continue;
            }

            String endStr = resList.peekLast();
            String currentStr = String.valueOf(cArray[i]);
            // 判断最后str是否以当前char结尾
            if (endStr.endsWith(currentStr)) {
                // 如果相同，则在最后String上追加char
                resList.offerLast(resList.pollLast() + currentStr);
            } else {
                // 如果不同，则追加新的String元素
                resList.offerLast(currentStr);
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        // test case
        Solution solution = new Solution();
        //   String testWord = "aabbacaaadddaa";
        //   System.out.println("result = " + Arrays.toString(solution.mergeChar(testWord.toCharArray()).toArray()));
        /**
         * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
         * 输出: true
         * aa,d,b,bb,dd,cacc
         *  aa,d,bbc,c
         * */
        System.out.println("solution.isInterleave(\"\") = " + solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
