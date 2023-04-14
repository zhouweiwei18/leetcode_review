package com.nuaa.main.string;

public class Solution_5 {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = getStr(s, i, i);
            String str2 = getStr(s, i, i + 1);
            if (str1.length() >= str2.length())
                ans = str1.length() > ans.length() ? str1 : ans;
            else
                ans = str2.length() > ans.length() ? str2 : ans;
        }
        return ans;
    }

    public static String getStr(String s, int left, int right) {
        if (left != right) {
            // 双字符扩散
            if (right >= s.length() || s.charAt(left) != s.charAt(right)) return "";
        }
        left--;
        right++;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }
        left++;
        return s.substring(left, right);
    }

}
