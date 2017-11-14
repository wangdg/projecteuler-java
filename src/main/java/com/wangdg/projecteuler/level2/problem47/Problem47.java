package com.wangdg.projecteuler.level2.problem47;

import org.apache.commons.math3.primes.Primes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://projecteuler.net/problem=47
 */
public class Problem47 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 644;
        while (true) {
            if (getPrimeFactorCount(n) == 4
                    && getPrimeFactorCount(n + 1) == 4
                    && getPrimeFactorCount(n + 2) == 4
                    && getPrimeFactorCount(n + 3) == 4) {
                System.out.println("result = " + n);
                return;
            }
            n += 1;
        }
    }

    private static int getPrimeFactorCount(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            Set<Integer> primes = new HashSet<>(Primes.primeFactors(n));
            map.put(n, primes.size());
            return primes.size();
        }
    }
}
