package com.nuaa.main;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int[] A = new int[a];
            for (int i = 0; i < a; i++) {
                A[i] = in.nextInt();
            }
            int b = in.nextInt();
            int[] B = new int[b];
            for (int i = 0; i < b; i++) {
                B[i] = in.nextInt();
            }
            int[] ans = new int[a + b];
            int index = 0;

            int index_a = 0;
            int index_b = 0;
            while (index_a < a && index_b < b) {
                if (A[index_a] <= B[index_b]) {
                    ans[index++] = A[index_a++];
                } else {
                    ans[index++] = B[index_b++];
                }
            }
            while (index_a < a) {
                ans[index++] = A[index_a++];
            }
            while (index_b < b) {
                ans[index++] = B[index_b++];
            }
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }
}

