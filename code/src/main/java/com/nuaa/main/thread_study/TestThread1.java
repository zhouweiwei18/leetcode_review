package com.nuaa.main.thread_study;

public class TestThread1 {

    public static void main(String[] args) {
        int cal = cal(10, 3);
        System.out.println(cal);
    }

    public static int cal(int N, int m) {
        int[] arr = new int[N + 1];
        int count = 0;
        int num = 0;
        while (count < N - 1) {
            for (int i = 1; i <= N; i++) {
                if (arr[i] == 1)
                    continue;
                else {
                    num++;
                    if (num == m) {
                        count++;
                        arr[i] = 1;
                        if (count >= N - 1) break;
                        num = 0;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) return i;
        }
        return -1;
    }

}
