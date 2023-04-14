package com.nuaa.main.bfs;

import java.util.*;

public class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord)) return 0;
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        map.put(beginWord, 1);

        while (queue.size() != 0) {
            String word = queue.poll();
            int path = map.get(word);
            for (int j = 0; j < word.length(); j++) {
                char[] chs = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chs[j] = ch;
                    String newWord = String.valueOf(chs);
                    if (endWord.equals(newWord)) return path + 1;
                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, path + 1);
                        queue.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
