package com.nuaa.main.string;

public class Solution_43 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int value1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int value2 = num2.charAt(j) - '0';
                int sum = ans[i + j + 1] + value1 * value2;
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) {
                continue;
            }
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
