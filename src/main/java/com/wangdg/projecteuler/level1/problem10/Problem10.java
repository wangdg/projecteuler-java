package com.wangdg.projecteuler.level1.problem10;

import org.apache.commons.math3.primes.Primes;

/**
 The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

 Find the sum of all the primes below two million.

 还是数据类型的坑，要用long类型
 */
public class Problem10 {

    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i <= 2000000; i++) {
            if (Primes.isPrime(i)) {
                sum += i;
            }
        }
        System.out.println("result = " + sum);
    }
}
