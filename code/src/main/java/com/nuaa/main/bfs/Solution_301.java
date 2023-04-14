package com.nuaa.main.bfs;

import java.util.*;

public class Solution_301 {

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        if (isValid(s)) {
            ans.add(s);
            return ans;
        }
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean flag = false;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.pollFirst();
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    String newStr = str.substring(0, j) + str.substring(j + 1);
                    if (visited.contains(newStr)) continue;
                    if (isValid(newStr)) {
                        flag = true;
                        set.add(newStr);
                    }
                    visited.add(newStr);
                    queue.addLast(newStr);
                }
            }
            if (flag) break;
        }
        ans.addAll(set);
        if (ans.size() == 0) {
            ans.add(s);
        }
        return ans;
    }

    //判定是否有效
    public boolean isValid(String s) {
        //创建栈
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
