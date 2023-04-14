package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17 {

    List<String> ans = new ArrayList<>();
    // 创建Map
    Map<Integer, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        if (digits.equals(""))
            return ans;

        char[] chs = digits.toCharArray();
        dfs(chs, 0, "");
        return ans;
    }

    public void dfs(char[] chs, int i, String path) {
        // 判断出口
        if (path.length() == chs.length) {
            ans.add(path);
            return;
        }
        if (i >= chs.length) return;

        StringBuilder sb = new StringBuilder(path);
        // 获取当前i的数字
        char ch = chs[i];
        char[] chars = map.get(ch - '0');
        for (int j = 0; j < chars.length; j++) {
            // 对于每一个都进行遍历
            sb.append(chars[j]);
            dfs(chs, i + 1, sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
