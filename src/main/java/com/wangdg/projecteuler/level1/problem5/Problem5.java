package com.wangdg.projecteuler.level1.problem5;

import org.apache.commons.math3.primes.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

 */
public class Problem5 {

    public static void main(String[] args) {

        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i <= 20; i++) {
            factors.addAll(Primes.primeFactors(i));
        }
        /*
        这里得到质数因子如下：
        [17, 2, 3, 19, 5, 7, 11, 13]
        2, 3比较特殊
         */

        factors = new HashSet<>();
        factors.add(16);
        factors.add(9);
        factors.add(5);
        factors.add(7);
        factors.add(11);
        factors.add(13);
        factors.add(17);
        factors.add(19);

        int result = factors.stream().reduce(Integer.valueOf(1), (a, v) -> a * v);
        System.out.println("result = " + result);
    }
}
