package com.wangdg.projecteuler.level2.problem30;

import org.apache.commons.math3.util.ArithmeticUtils;

/**
 * https://projecteuler.net/problem=30
 *
 * 问题是何时终止循环
 */
public class Problem30 {

    public static void main(String[] args) {
        long max = 4 * ArithmeticUtils.pow(9, 5);
        long sum = 0;
        for (int i = 10; i <= max; i++) {
            if (i == getPowSum(i)) {
                sum += i;
            }
        }
        System.out.println("result = " + sum);
    }

    protected static long getPowSum(int n) {
        int temp = n;
        long sum = 0;
        while (temp > 0) {
            sum += ArithmeticUtils.pow(temp % 10, 5);
            temp = temp / 10;
        }
        return sum;
    }
}
