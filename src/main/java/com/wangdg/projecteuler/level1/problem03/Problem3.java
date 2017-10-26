package com.wangdg.projecteuler.level1.problem03;

import org.apache.commons.math3.primes.Primes;

/**
 The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {

    public static void main(String[] args) {

        long input = 600851475143L;
        int n = (int) Math.sqrt(input);

        System.out.println("n = " + n);

        int result = 1;
        for (int i = n; i > 2; i--) {
            if (input % i == 0 && Primes.isPrime(i)) {
                result = i;
                break;
            }
        }

        System.out.println("result = " + result);
    }
}
