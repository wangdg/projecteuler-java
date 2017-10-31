package com.wangdg.projecteuler.level1.problem21;

import org.apache.commons.math3.primes.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        for (int a = 1; a <= 10000; a++) {
            if (a == 1 || Primes.isPrime(a) || numbers.contains(a)) {
                continue;
            }
            int b = d(a);
            if (d(b) == a && a != b) {
                numbers.add(a);
                numbers.add(b);
            }
        }
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("result = " + sum);
    }

    public static int d(int n) {
        int h = n / 2 + 1;
        int sum = 0;
        for (int i = 1; i <= h; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
