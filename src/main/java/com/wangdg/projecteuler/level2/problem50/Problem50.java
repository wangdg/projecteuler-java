package com.wangdg.projecteuler.level2.problem50;

import org.apache.commons.math3.primes.Primes;

import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=50
 */
public class Problem50 {

    public static void main(String[] args) {

        List<Integer> primes = getAllPrimes();

        int maxLength = 1;
        int resultPrime = 0;

        int size = primes.size();
        for (int i = 0; i < size; i++) {
            int length = size - i;
            if (maxLength > length) break;
            for (int l = maxLength; l <= length; l++) {
                int sum = getSum(primes, i, l);
                if (sum < 0) {
                    break;
                }
                if (primes.contains(sum)) {
                    maxLength = l;
                    resultPrime = sum;
                    System.out.println("i = " + i + ", l = " + l + ", sum = " + sum);
                }
            }
        }

        System.out.println("result = " + resultPrime);
    }

    protected static int getSum(List<Integer> list, int start, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += list.get(start + i);
            if (sum > 1000000) {
                return -1;
            }
        }
        return sum;
    }

    protected static List<Integer> getAllPrimes() {
        List<Integer> primes = new ArrayList<>();
        int n = 1;
        while (true) {
            int p = Primes.nextPrime(n);
            if (p < 1000000) {
                primes.add(p);
            } else {
                break;
            }
            n = p + 1;
        }
        return primes;
    }
}
