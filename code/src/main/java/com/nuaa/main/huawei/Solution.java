package com.nuaa.main.huawei;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        String a = "3[3[a]]";
        String s = decodeString(a);
        System.out.println(s);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public static String decodeString(String s) {
        //创建栈
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
                continue;
            }
            String temp = "";
            int flag = 0;
            while (!stack.isEmpty()) {
                if (stack.peek() == '[' && flag == 1) break;
                char ch = stack.pop();
                if (ch == '[') flag++;
                temp = ch + temp;
            }
            flag = 0;
            char[] chs = getString(temp).toCharArray();

            for (int j = 0; j < chs.length; j++) stack.push(chs[j]);

        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }

    public static String getString(String str) {
        String[] strs = str.split("\\[");
        int nums = Integer.parseInt(strs[0]);
        String ss = "";
        while (nums > 0) {
            ss = ss + strs[1];
            nums--;
        }
        return ss;
    }
}
