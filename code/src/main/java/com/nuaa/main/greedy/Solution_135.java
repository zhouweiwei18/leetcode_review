package com.nuaa.main.greedy;

import java.util.Arrays;

public class Solution_135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) nums[i] = nums[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) nums[i] = Math.max(nums[i + 1] + 1, nums[i]);
        }

        int sum = 0;
        for (int i : nums) sum += i;
        return sum;
    }


    // 超时
    /*public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < ratings.length; i++) {
            if (!queue.contains(ratings[i])) queue.add(ratings[i]);
        }
        Collections.sort(queue);
        int[] nums = new int[ratings.length];
        while (queue.size() != 0) {
            int val = queue.remove(0);
            for (int i = 0; i < ratings.length; i++) {
                if (ratings[i] == val) {
                    if ((i - 1 < 0 && i + 1 < ratings.length && ratings[i + 1] < ratings[i]) || (i - 1 >= 0 && ratings[i - 1] < ratings[i] || i + 1 < ratings.length && ratings[i + 1] < ratings[i]) || (i + 1 >= ratings.length && i - 1 >= 0 && ratings[i - 1] < ratings[i])) {
                        int left = i - 1 >= 0 && ratings[i - 1] != ratings[i] ? nums[i - 1] : 0;
                        int right = i + 1 < ratings.length && ratings[i + 1] != ratings[i] ? nums[i + 1] : 0;
                        nums[i] = Math.max(left, right) + 1;
                    } else {
                        nums[i] = 1;
                    }
                }
            }
        }
        int sum = 0;
        for (int i : nums) sum += i;
        return sum;
    }*/
}
