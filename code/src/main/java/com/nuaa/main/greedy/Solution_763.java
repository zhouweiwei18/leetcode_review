package com.nuaa.main.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_763 {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int max_index = map.get(s.charAt(0));
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (max_index == i) {
                ans.add(i + 1 - flag);
                flag = i + 1;
                if (i + 1 < s.length()) {
                    max_index = map.get(s.charAt(i + 1));
                } else {
                    return ans;
                }
            } else {
                char ch = s.charAt(i);
                max_index = Math.max(map.get(ch), max_index);
            }
        }
        return ans;
    }
}
