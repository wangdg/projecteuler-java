package com.wangdg.projecteuler.level3.problem60;

import org.apache.commons.math3.primes.Primes;

import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=60
 */
public class Problem60 {

    private static final int LIMIT = 10000;

    public static void main(String[] args) {

        List<Integer> primeList = getPrimes(LIMIT);

        int primeSize = primeList.size();
        for (int i1 = 0; i1 < primeSize; i1++) {
            int p1 = primeList.get(i1);
            for (int i2 = i1 + 1; i2 < primeSize; i2++) {
                int p2 = primeList.get(i2);
                if (!isPair(p1, p2)) continue;
                for (int i3 = i2 + 1; i3 < primeSize; i3++) {
                    int p3 = primeList.get(i3);
                    if (!isPair(p1, p3) || !isPair(p2, p3)) continue;
                    for (int i4 = i3 + 1; i4 < primeSize; i4++) {
                        int p4 = primeList.get(i4);
                        if (!isPair(p1, p4) || !isPair(p2, p4) || !isPair(p3, p4)) continue;
                        for (int i5 = i4 + 1; i5 < primeSize; i5++) {
                            int p5 = primeList.get(i5);
                            if (!isPair(p1, p5) || !isPair(p2, p5) || !isPair(p3, p5) || !isPair(p4, p5)) continue;
                            System.out.println("result = " + (p1 + p2 + p3 + p4 + p5));
                            return;
                        }
                    }
                }
            }
        }
    }

    private static boolean isPair(int a, int b) {
        if (!Primes.isPrime(Integer.parseInt(a + "" + b))
                || !Primes.isPrime(Integer.parseInt(b + "" + a))) {
            return false;
        } else {
            return true;
        }
    }

    private static List<Integer> getPrimes(int limit) {
        List<Integer> list = new ArrayList<>();
        int p = 0;
        while (p < limit) {
            p = Primes.nextPrime(p + 1);
            list.add(p);
        }
        return list;
    }
}
