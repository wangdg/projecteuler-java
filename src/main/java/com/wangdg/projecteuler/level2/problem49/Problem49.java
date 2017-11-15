package com.wangdg.projecteuler.level2.problem49;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.apache.commons.math3.primes.Primes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://projecteuler.net/problem=49
 */
public class Problem49 {

    public static void main(String[] args) {

        List<Integer> primeList = new ArrayList<>();

        for (int i = 1000; i <= 9999; i++) {
            if (Primes.isPrime(i)) {
                primeList.add(i);
            }
        }

        int primeSize = primeList.size();
        for (int i = 0; i < primeSize; i++) {
            int p1 = primeList.get(i);
            if (p1 == 1487) {
                continue;
            }
            List<Integer> permutationPrimes = getPermutationPrimes(p1).stream().sorted().collect(Collectors.toList());
            for (Integer p2 : permutationPrimes) {

                if (p2 <= p1) continue;

                int p3 = p2 + Math.abs(p2 - p1);

                Set<Integer> results = new HashSet<>();
                results.add(p1);
                results.add(p2);
                results.add(p3);

                if (results.size() == 3 && Primes.isPrime(p3) && permutationPrimes.contains(p3)) {
                    String str = results.stream().sorted()
                            .map(integer -> integer.toString())
                            .reduce("", (a, s) -> a + s);
                    System.out.println("result = " + str);
                    return;
                }
            }
        }
    }

    protected static Set<Integer> getPermutationPrimes(int n) {

        List<Integer> digits = new ArrayList<>();
        digits.add((n / 1) % 10);
        digits.add((n / 10) % 10);
        digits.add((n / 100) % 10);
        digits.add((n / 1000) % 10);

        Set<Integer> primes = new HashSet<>();

        PermutationIterator<Integer> iterator = new PermutationIterator<>(digits);
        while (iterator.hasNext()) {
            List<Integer> p = iterator.next();
            int v = p.get(0) + 10 * p.get(1) + 100 * p.get(2) + 1000 * p.get(3);
            if (v == n || v < 1000) {
                continue;
            }
            if (Primes.isPrime(v)) {
                primes.add(v);
            }
        }

        return primes;
    }
}
