package com.wangdg.projecteuler.level1.problem16;

import java.math.BigInteger;
import java.util.Arrays;

/**
 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

 What is the sum of the digits of the number 2^1000?

 计算大数

 */
public class Problem16 {

    public static void main(String[] args) {
        System.out.println("result = " + getResult1());
    }

    protected static long getResult1() {
        BigInteger n = new BigInteger("2");
        String str = n.pow(1000).toString();
        char[] charArray = str.toCharArray();
        long sum = 0;
        for (char c : charArray) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }
}
