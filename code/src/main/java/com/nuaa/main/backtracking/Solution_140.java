package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_140 {
    List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backtracking(s, wordDict, 0);
        return ans;
    }

    public void backtracking(String s, List<String> wordDict, int startIndex) {

        if (startIndex > s.length()) return;
        if (startIndex == s.length()) {
            ans.add(s.trim());
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (wordDict.contains(s.substring(startIndex, i + 1))) {
                s = s.substring(0, i + 1) + " " + s.substring(i + 1);
                backtracking(s, wordDict, i + 2);
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }
    }

}
