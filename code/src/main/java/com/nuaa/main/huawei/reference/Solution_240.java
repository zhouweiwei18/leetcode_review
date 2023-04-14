package com.nuaa.main.huawei.reference;

public class Solution_240 {

    // 利用性质求解
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target)
                j--;
            else
                i++;
        }
        return false;
    }

    // 二分查找加速
    /*public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int ans = binarySearch(matrix[i], target);
            if (ans == -1 || matrix[i][ans] != target)
                continue;
            else
                return true;
        }
        return false;
    }

    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == target) return middle;
            if (array[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }*/
}
