package com.nuaa.main.greedy;

public class Solution_738 {

    public int monotoneIncreasingDigits(int n) {
        if (n >= 0 && n <= 9) return n;
        String str = String.valueOf(n);
        char[] chs = str.toCharArray();
        int flag = chs.length;
        for (int i = chs.length - 1; i >= 1; i--) {
            if (chs[i - 1] > chs[i]) {
                flag = i;
                chs[i - 1]--;
            }
        }
        for (int i = flag; i <= chs.length - 1; i++) chs[i] = '9';
        return Integer.parseInt(String.valueOf(chs));
    }


    // 暴力超时
    /*public int monotoneIncreasingDigits(int n) {
        while (n-- >= 0) {
            if (isTrue(n)) return n;
        }

        return -1;
    }

    public boolean isTrue(int value) {
        if (value >= 0 && value < 10) return true;
        String str = String.valueOf(value);
        char[] chs = str.toCharArray();
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] < chs[i - 1]) return false;
        }
        return true;
    }*/
}
