package com.nuaa.main.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_22 {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, "");
        return ans;
    }
    public void dfs(int n, String path) {
        // 判断出口
        if (path.length() == (2 * n)) {
            // 判断字符串是否合法
            if (isTure(path)) {
                ans.add(path);
            }
        }
        // 递归添加括号
        dfs(n, path + "(");
        dfs(n, path + ")");
        path.substring(0, path.length() - 1);
    }

    private boolean isTure(String path) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chs = path.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (stack.size() == 0) {
                if (chs[i] == ')') {
                    return false;
                } else {
                    stack.push(chs[i]);
                    continue;
                }
            }
            if (chs[i] == '(') {
                stack.push(chs[i]);
                continue;
            }
            if (chs[i] == ')') {
                char ch = stack.pop().charValue();
                if (ch == '(') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
