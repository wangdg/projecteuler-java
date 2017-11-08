package com.wangdg.projecteuler.level2.problem37;

import org.apache.commons.math3.primes.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=37
 */
public class Problem37 {

    public static void main(String[] args) {
        int p = 11;
        Set<Integer> primes = new HashSet<>();
        while (true) {

            if (isTruncatablePrime(p)) {
                primes.add(p);
            }

            if (primes.size() == 11) {
                break;
            }

            p = Primes.nextPrime(p + 1);
        }

        int sum = primes.stream().mapToInt(Integer::intValue).sum();
        System.out.println("result = " + sum);
    }

    protected static boolean isTruncatablePrime(int n) {
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i);
            if (!Primes.isPrime(Integer.parseInt(s))) {
                return false;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(0, str.length() - i);
            if (!Primes.isPrime(Integer.parseInt(s))) {
                return false;
            }
        }
        return true;
    }
}
