package com.nuaa.main.prefix_sum;

public class Solution_1248 {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        // 0001112222
        // 0001112222
        int count = numberOfSubarrays(arr, 2);
        System.out.println(count);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }


    // 前缀和 优化
//    public static int numberOfSubarrays(int[] nums, int k) {
//        int ans = 0;
//        int[] prefix = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                prefix[i] = nums[i] % 2 == 1 ? 1 : 0;
//
//                continue;
//            }
//            prefix[i] = prefix[i - 1] + (nums[i] % 2 == 1 ? 1 : 0);
//
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1); // 边界
//        for (int x : prefix) {
//            if (map.containsKey(x - k)) {
//                ans += map.get(x - k);
//            }
//            map.put(x, map.getOrDefault(x, 0) + 1);
//        }
//        return ans;
//    }


    // 原始前缀和(超时)
//    public static int numberOfSubarrays(int[] nums, int k) {
//        int ans = 0;
//        int[] prefix = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                prefix[i] = nums[i] % 2 == 1 ? 1 : 0;
//                continue;
//            }
//            prefix[i] = prefix[i - 1] + (nums[i] % 2 == 1 ? 1 : 0);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (i == 0) {
//                    if (prefix[j] == k)
//                        ans++;
//
//                    continue;
//                }
//                if (i > 0 && prefix[j] - prefix[i - 1] == k) ans++;
//            }
//        }
//
//        return ans;
//    }

    // 滑动窗口
//    public static int numberOfSubarrays(int[] nums, int k) {
//        int left = 0;
//        int ans = 0;
//        int number = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 == 1) {
//                number++;
//                if (number == k) {
//                    // 计算右边
//                    int rightCount = 0;
//                    int temp = i;
//                    while (++i < nums.length && nums[i] % 2 == 0) {
//                        rightCount++;
//                    }
//                    i = temp;
//                    int leftCount = 0;
//                    //统计左边
//                    while (nums[left] % 2 == 0) {
//                        leftCount++;
//                        left++;
//                    }
//                    ans += (rightCount + 1) * (leftCount + 1);
//                    left++;
//                    number--;
//                }
//            }
//        }
//        return ans;
//    }
}
