package com.bikercoder.study.algorithm.string;

import java.util.Stack;

/**
 * @author caoguo
 * @Description： 20. 有效的括号  https://leetcode-cn.com/problems/valid-parentheses/
 * @date：2021/11/3 10:13 下午
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid(new String("((")));

    }

    /**
     * 迭代 借助栈存放符号
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
}
