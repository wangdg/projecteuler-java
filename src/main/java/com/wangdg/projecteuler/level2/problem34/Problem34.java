package com.wangdg.projecteuler.level2.problem34;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

/**
 * https://projecteuler.net/problem=34
 *
 * 重点是找到上限
 */
public class Problem34 {

    public static void main(String[] args) {

        int top = 1;
        while (true) {
            // 9! = 362880
            String str = String.valueOf(top * 362880L);
            if (str.length() < top) {
                break;
            }
            top += 1;
        }

        // 找到位数限制
        System.out.println("top = " + top);

        long size = ArithmeticUtils.pow(10, top);

        long sum = 0;
        for (long i = 3; i < size; i++) {
            if (isTarget(i)) {
                sum += i;
            }
        }
        System.out.println("result = " + sum);
    }

    protected static boolean isTarget(long n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += CombinatoricsUtils.factorial(Integer.parseInt("" + c));
        }
        return sum == n;
    }
}
