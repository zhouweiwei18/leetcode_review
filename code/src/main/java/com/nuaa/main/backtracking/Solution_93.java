package com.nuaa.main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_93 {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return ans;
    }

    public void backtracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1))
                ans.add(s);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 判断是否合法
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backtracking(s, i + 2, pointNum);
                s = s.substring(0, i + 1) + s.substring(i + 2);
                pointNum--;
            } else {
                break;
            }
        }
    }

    public boolean isValid(String s, int start, int end) {
        if (start > end) return false;

        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) return false;

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
