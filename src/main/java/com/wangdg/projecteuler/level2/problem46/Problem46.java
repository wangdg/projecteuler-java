package com.wangdg.projecteuler.level2.problem46;

import org.apache.commons.math3.primes.Primes;

/**
 * https://projecteuler.net/problem=46
 */
public class Problem46 {

    public static void main(String[] args) {
        for (int i = 9; i < Integer.MAX_VALUE; i++) {
            if (!isOddComposite(i)) {
                continue;
            }
            if (!isTarget(i)) {
                System.out.println("result = " + i);
                return;
            }
        }
    }

    protected static boolean isTarget(int n) {
        int p = 2;
        while (true) {
            int d = n - p;
            if (d < 0) {
                break;
            }
            double sqrt = Math.sqrt(d / 2);
            if (sqrt == (int)sqrt) {
                return true;
            }
            p = Primes.nextPrime(p + 1);
        }
        return false;
    }

    protected static boolean isOddComposite(int n) {
        return n % 2 == 1 && !Primes.isPrime(n);
    }
}
