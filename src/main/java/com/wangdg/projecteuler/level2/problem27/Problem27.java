package com.wangdg.projecteuler.level2.problem27;

import org.apache.commons.math3.primes.Primes;

/**
 * https://projecteuler.net/problem=27
 */
public class Problem27 {

    public static void main(String[] args) {
        int resultA = 0;
        int resultB = 0;
        int maxLength = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int l = getConsecutiveIntegerLength(a, b);
                if (l > maxLength) {
                    resultA = a;
                    resultB = b;
                    maxLength = l;
                }
            }
        }

        System.out.println("result = " + resultA * resultB);
    }

    protected static int getConsecutiveIntegerLength(int a, int b) {
        int n = 0;
        while (true) {
            int val = n * n + a * n + b;
            if (Primes.isPrime(val)) {
                n++;
            } else {
                return n;
            }
        }
    }
}
