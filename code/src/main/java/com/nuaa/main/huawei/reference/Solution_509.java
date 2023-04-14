package com.nuaa.main.huawei.reference;

public class Solution_509 {
    public int fib(int n) {
        if(n == 0) return  0;
        if(n == 1) return  1;

        return  fib(n-1) + fib(n-2);
    }
}
