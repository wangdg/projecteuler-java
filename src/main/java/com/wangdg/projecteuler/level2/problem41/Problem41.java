package com.wangdg.projecteuler.level2.problem41;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.apache.commons.math3.primes.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=41
 */
public class Problem41 {

    public static void main(String[] args) {
        for (int n = 9; n > 0; n--) {
            Set<Integer> digits = getDigits(n);
            PermutationIterator<Integer> iterator = new PermutationIterator<>(digits);
            int maxPrime = 0;
            while (iterator.hasNext()) {
                String str = iterator.next().stream()
                        .map(v -> v.toString())
                        .reduce("", (a, v) -> a + v);
                int integer = Integer.parseInt(str);
                if (Primes.isPrime(integer) && maxPrime < integer) {
                    maxPrime = integer;
                }
            }
            if (maxPrime != 0) {
                System.out.println("result = " + maxPrime);
                break;
            }
        }
    }

    protected static Set<Integer> getDigits(int n) {
        Set<Integer> digits = new HashSet<>();
        for (int i = 0; i < n; i++) {
            digits.add(i + 1);
        }
        return digits;
    }
}
