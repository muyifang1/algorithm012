package leetcode.validparentheses;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author YangQi
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        HashMap<Character, Character> parentheseMap = new HashMap<>();
        parentheseMap.put(')', '(');
        parentheseMap.put(']', '[');
        parentheseMap.put('}', '{');

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (parentheseMap.containsKey(c)) {
                // 失败条件：stack为空 或者 不匹配
                if (stack.isEmpty() || !stack.peek().equals(parentheseMap.get(c))) {
                    return false;
                }
                // 匹配成功则 pop 出栈
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        // 最终如果栈不为空 则 不符合标准
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses demo = new ValidParentheses();
        System.out.println("demo.isValid(\"()\") = " + demo.isValid2("()"));
        System.out.println("demo.isValid(\"({[]})\") = " + demo.isValid2("({[]})"));
        System.out.println("demo.isValid(\"{{]}}\") = " + demo.isValid2("{{]}}"));
    }
}
