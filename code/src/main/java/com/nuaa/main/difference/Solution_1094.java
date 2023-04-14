package com.nuaa.main.difference;

public class Solution_1094 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 2, 8}, {4, 4, 6}, {10, 8, 9}};
        boolean flag = carPooling(arr, 11);
        System.out.println(flag);
    }

    // 差分求解
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1005];
        for (int[] arr : trips) {
            diff[arr[1]] += arr[0];
            diff[arr[2]] -= arr[0];
        }

        int count = 0;
        for (int i = 0; i <= 1000; i++) {
            count += diff[i];
            if (count > capacity) return false;
        }
        return true;
    }

    // 暴力求解
//    public static boolean carPooling(int[][] trips, int capacity) {
//        Arrays.sort(trips, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int total = 0;
//        for (int i = 0; i < trips.length; i++) {
//            int[] line = trips[i];
//            int number = line[0];
//            int from = line[1];
//            int to = line[2];
//            // 查看是否有人下车
//            int offNumber = getOffNumber(from, map);
//            total -= offNumber;
//            total += number;
//            if (total > capacity) return false;
//            map.put(to, map.getOrDefault(to, 0) + number);
//        }
//        return true;
//    }
//
//    public static int getOffNumber(int index, Map<Integer, Integer> map) {
//        int count = 0;
//        List<Integer> list = new LinkedList<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getKey() <= index) {
//                list.add(entry.getKey());
//            }
//        }
//
//        for (Integer i : list) {
//            count += map.remove(i);
//        }
//        return count;
//    }
}
