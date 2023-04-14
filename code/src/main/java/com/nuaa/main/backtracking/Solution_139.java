package com.nuaa.main.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashSet<>(), 0);
    }
    public boolean dfs(String s, List<String> wordDict, Set<Integer> set, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            if (set.contains(i)) {
                continue;
            }
            if (wordDict.contains(s.substring(start, i + 1))) {
                if (dfs(s, wordDict, set, i + 1)) {
                    return true;
                }
                set.add(i);
            }
        }
        return false;
    }
}
