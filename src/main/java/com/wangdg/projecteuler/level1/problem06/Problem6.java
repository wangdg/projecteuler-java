package com.wangdg.projecteuler.level1.problem06;

/**
 The sum of the squares of the first ten natural numbers is,

 12 + 22 + ... + 102 = 385
 The square of the sum of the first ten natural numbers is,

 (1 + 2 + ... + 10)2 = 552 = 3025
 Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

 Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {

    public static void main(String[] args) {

        long sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += (i + 1) * (i + 1);
        }

        System.out.println(5050 * 5050 - sum);
    }
}
