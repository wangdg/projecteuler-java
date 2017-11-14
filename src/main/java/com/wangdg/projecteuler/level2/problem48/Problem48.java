package com.wangdg.projecteuler.level2.problem48;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=48
 */
public class Problem48 {

    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            BigInteger n = BigInteger.valueOf(i);
            sum = sum.add(n.pow(i));
        }
        String str = sum.toString();
        System.out.println("result = " + str.substring(str.length() - 10));
    }
}
