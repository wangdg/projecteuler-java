package com.wangdg.projecteuler.level1.problem20;

import java.math.BigDecimal;

/**
 n! means n × (n − 1) × ... × 3 × 2 × 1

 For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

 Find the sum of the digits in the number 100!
 */
public class Problem20 {

    public static void main(String[] args) {
        BigDecimal product = BigDecimal.ONE;
        for (int i = 1; i <= 100; i++) {
            product = product.multiply(new BigDecimal(i));
        }

        String str = product.toString();
        char[] array = str.toCharArray();
        int sum = 0;
        for (char c : array) {
            sum += Integer.parseInt("" + c);
        }
        System.out.println("result = " + sum);
    }
}
