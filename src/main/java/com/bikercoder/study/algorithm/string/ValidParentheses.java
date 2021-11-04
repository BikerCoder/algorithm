package com.bikercoder.study.algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author caoguo
 * @Description： 20. 有效的括号  https://leetcode-cn.com/problems/valid-parentheses/
 * @date：2021/11/3 10:13 下午
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid2(new String("{}()[")));

    }

    /**
     * 迭代 借助栈存放符号 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (!stk.isEmpty()) {
                if (chars[i] == '}' && stk.peek() == '{') {
                    stk.pop();
                    continue;
                } else if (chars[i] == ')' && stk.peek() == '(') {
                    stk.pop();
                    continue;
                } else if (chars[i] == ']' && stk.peek() == '[') {
                    stk.pop();
                    continue;
                }
            }
            stk.push(chars[i]);

        }
        return stk.isEmpty();
    }

    /**
     * 迭代 借助栈存放符号 时间复杂度O(n) 空间复杂度O(n + x) x为字符集个数 (){}[] 字符集个数为6
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 == 1) {
            return false;
        }
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : chars) {
            if (map.containsKey(c)) {
                if (stk.isEmpty() || stk.peek() != map.get(c)) {
                    return false;
                }
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }

}
