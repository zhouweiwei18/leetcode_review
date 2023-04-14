package com.nuaa.main.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_20 {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        // 创建栈
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {
            if (stack.isEmpty() || chs[i] == '[' || chs[i] == '(' || chs[i] == '{') {
                stack.push(chs[i]);
                continue;
            } else {
                if (chs[i] == ']') {
                    if (stack.pop() != '[') return false;
                }

                if (chs[i] == ')') {
                    if (stack.pop() != '(') return false;
                }

                if (chs[i] == '}') {
                    if (stack.pop() != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
