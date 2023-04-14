package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_131 {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return ans;
    }
    public void backtracking(String str, int startIndex) {
        if (startIndex >= str.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (isTrue(str, startIndex, i + 1))
                path.add(str.substring(startIndex, i + 1));
            else
                continue;
            backtracking(str, i + 1);
            path.remove(path.size() - 1);
        }
    }
    public boolean isTrue(String s, int start, int end) {
        String str = s.substring(start, end);
        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)){
                left++;
                right--;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
