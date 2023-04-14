package com.nuaa.main.slidewindow;

public class Solution_1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int consume = Math.abs(s.charAt(i) - t.charAt(i));
            maxCost = maxCost - consume;
            if (maxCost >= 0) {
                ans = Math.max(ans, i - left + 1);
            } else {
                while (maxCost < 0) {
                    int left_consume = Math.abs(s.charAt(left) - t.charAt(left));
                    maxCost += left_consume;
                    left++;
                }
            }
        }
        return ans;
    }
}
