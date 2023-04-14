package com.nuaa.main.window;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_76 {

    static HashMap<Character, Integer> t_map = new HashMap<>();
    static HashMap<Character, Integer> s_map = new HashMap<>();

    public static String minWindow(String s, String t) {

        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            t_map.put(t.charAt(i), t_map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = -1;
        int s_len = s.length();
        int len = Integer.MAX_VALUE;
        int ans_l = -1;
        int ans_r = -1;

        while (r < s_len) {
            ++r;
            if (r < s.length() && t_map.containsKey(s.charAt(r)))
                s_map.put(s.charAt(r), s_map.getOrDefault(s.charAt(r), 0) + 1);
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ans_l = l;
                    ans_r = l + len;
                }
                if (t_map.containsKey(s.charAt(l))) {
                    s_map.put(s.charAt(l), s_map.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }

        return ans_r == -1 ? "" : s.substring(ans_l, ans_r);
    }

    private static boolean check() {
        for (Map.Entry<Character, Integer> entry : t_map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (s_map.getOrDefault(key, 0) < val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String str = minWindow(s, t);
        System.out.println(str);

    }

}
