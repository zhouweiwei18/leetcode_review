package com.nuaa.main.sort;

public class Main {

    // 冒泡排序
    public void bubbleSortOpt(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 选择排序
    public void selectSort(int[] arr) {
        // 遍历所有的数
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 把当前遍历的数和后面所有的数进行比较，并记录下最小的数的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 记录最小的数的下标
                    minIndex = j;
                }
            }
            // 如果最小的数和当前遍历的下标不一致，则交换
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // 插入排序
    public void insertSort(int[] arr) {
        // 遍历所有数字
        for (int i = 1; i < arr.length - 1; i++) {
            // 当前数字比前一个数字小
            if (arr[i] < arr[i - 1]) {
                int j;
                // 把当前遍历的数字保存起来
                int temp = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    // 前一个数字赋给后一个数字
                    arr[j + 1] = arr[j];
                }
                // 把临时变量赋给不满足条件的后一个元素
                arr[j + 1] = temp;
            }
        }
    }

    // 希尔排序
    public void shellSort(int[] arr) {
        // gap 为步长，每次减为原来的一半。
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {
                // 对本组数据执行直接插入排序
                for (int j = i + gap; j < arr.length; j += gap) {
                    // 如果 a[j] < a[j-gap]，则寻找 a[j] 位置，并将后面数据的位置都后移
                    if (arr[j] < arr[j - gap]) {
                        int k;
                        int temp = arr[j];
                        for (k = j - gap; k >= 0 && arr[k] > temp; k -= gap) {
                            arr[k + gap] = arr[k];
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 基数排序
     */
    public static void radixSort(int[] arr) {
        // 存放数组中的最大数字
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        // 计算最大数字是几位数
        int maxLength = (max + "").length();
        // 用于临时存储数据
        int[][] temp = new int[10][arr.length];
        // 用于记录在 temp 中相应的下标存放数字的数量
        int[] counts = new int[10];
        // 根据最大长度的数决定比较次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 每一个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                // 计算余数
                int remainder = arr[j] / n % 10;
                // 把当前遍历的数据放到指定的数组中
                temp[remainder][counts[remainder]] = arr[j];
                // 记录数量
                counts[remainder]++;
            }
            // 记录取的元素需要放的位置
            int index = 0;
            // 把数字取出来
            for (int k = 0; k < counts.length; k++) {
                // 记录数量的数组中当前余数记录的数量不为 0
                if (counts[k] != 0) {
                    // 循环取出元素
                    for (int l = 0; l < counts[k]; l++) {
                        arr[index] = temp[k][l];
                        // 记录下一个位置
                        index++;
                    }
                    // 把数量置空
                    counts[k] = 0;
                }
            }
        }
    }

    /**
     * 合并数组
     */
    public static void merge(int[] arr, int low, int middle, int high) {
        // 用于存储归并后的临时数组
        int[] temp = new int[high - low + 1];
        // 记录第一个数组中需要遍历的下标
        int i = low;
        // 记录第二个数组中需要遍历的下标
        int j = middle + 1;
        // 记录在临时数组中存放的下标
        int index = 0;
        // 遍历两个数组，取出小的数字，放入临时数组中
        while (i <= middle && j <= high) {
            // 第一个数组的数据更小
            if (arr[i] <= arr[j]) {
                // 把更小的数据放入临时数组中
                temp[index] = arr[i];
                // 下标向后移动一位
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        // 处理剩余未比较的数据
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        // 把临时数组中的数据重新放入原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            // 处理左边数组
            mergeSort(arr, low, middle);
            // 处理右边数组
            mergeSort(arr, middle + 1, high);
            // 归并
            merge(arr, low, middle, high);
        }
    }

    /**
     * 转化为大顶堆
     *
     * @param arr   待转化的数组
     * @param size  待调整的区间长度
     * @param index 结点下标
     */
    public void maxHeap(int[] arr, int size, int index) {
        // 左子结点
        int leftNode = 2 * index + 1;
        // 右子结点
        int rightNode = 2 * index + 2;
        int max = index;
        // 和两个子结点分别对比，找出最大的结点
        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        // 交换位置
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            // 因为交换位置后有可能使子树不满足大顶堆条件，所以要对子树进行调整
            maxHeap(arr, size, max);
        }
    }

    /**
     * 堆排序
     *
     * @param arr 待排序的整型数组
     */
    public void heapSort(int[] arr) {
        // 开始位置是最后一个非叶子结点，即最后一个结点的父结点
        int start = (arr.length - 1) / 2;
        // 调整为大顶堆
        for (int i = start; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        // 先把数组中第 0 个位置的数和堆中最后一个数交换位置，再把前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }

}
