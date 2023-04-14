package com.nuaa.main.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 11, 2, 111, 342, 534, 21, 23, 32, 42, 6};
        quick_sort(arr, 0, arr.length - 1);
        // Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quick_sort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int flag = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= flag) j--;
                if (i < j) arr[i++] = arr[j];
                while (i < j && arr[i] < flag) i++;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = flag;
            quick_sort(arr, left, i - 1);
            quick_sort(arr, i + 1, right);
        }
    }
}
