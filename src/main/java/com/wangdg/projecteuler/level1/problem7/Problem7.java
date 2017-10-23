package com.wangdg.projecteuler.level1.problem7;

import org.apache.commons.math3.primes.Primes;

import java.util.ArrayList;
import java.util.List;

/**
 By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

 What is the 10 001st prime number?
 */
public class Problem7 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(11);
        list.add(13);

        while (list.size() < 10001) {
            list.add(findNextPrime(list));
        }

        System.out.println("result = " + list.get(list.size() - 1));
    }

    protected static int findNextPrime(List<Integer> list) {
        int n = list.get(list.size() - 1) + 1;
        while (!Primes.isPrime(n)) {
            n++;
        }
        return n;
    }
}
