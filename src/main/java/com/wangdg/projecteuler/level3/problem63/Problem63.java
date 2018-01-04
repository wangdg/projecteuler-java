package com.wangdg.projecteuler.level3.problem63;

import java.math.BigInteger;

public class Problem63 {

    public static void main(String[] args) {
        int count = 0;
        for (int p = 1; p < 100; p++) { // 为什么是100。之前写的是int最大值。发现21以后找不到了。
            for (int n = 1; n < 10; n++) {
                BigInteger v = BigInteger.valueOf(n).pow(p);
                int length = v.toString().length();
                if (length == p) {
                    System.out.println(n + "^" + p + "=" + v);
                    count += 1;
                }
            }
        }
        System.out.println();
        System.out.println("result = " + count);
    }
}
