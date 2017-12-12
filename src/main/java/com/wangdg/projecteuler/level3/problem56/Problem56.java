package com.wangdg.projecteuler.level3.problem56;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=56
 */
public class Problem56 {

    public static void main(String[] args) {
        int max = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                int digitSum = getDigitSum(a, b);
                if (digitSum > max) {
                    max = digitSum;
                }
            }
        }
        System.out.println("result = " + max);
    }

    protected static int getDigitSum(int a, int b) {
        BigInteger i = BigInteger.valueOf(a);
        BigInteger pow = i.pow(b);
        char[] charArray = pow.toString().toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += Integer.parseInt("" + c);
        }
        return sum;
    }
}
