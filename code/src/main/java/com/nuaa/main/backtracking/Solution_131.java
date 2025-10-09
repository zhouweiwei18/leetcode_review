package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_131 {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return ans;
    }
    public void backtracking(String str, int startIndex, StringBuilder sb) {
        if (startIndex >= str.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (check(sb)){
                path.add(sb.toString());
                backtracking(str, i + 1, new StringBuilder());
                path.remove(path.size() -1 );
            }
        }
    }
    //helper method, 检查是否是回文
    private boolean check(StringBuilder sb){
        for (int i = 0; i < sb.length()/ 2; i++){
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){return false;}
        }
        return true;
    }
}
