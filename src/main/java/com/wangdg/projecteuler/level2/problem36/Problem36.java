package com.wangdg.projecteuler.level2.problem36;

import org.apache.commons.lang3.ArrayUtils;

/**
 * https://projecteuler.net/problem=36
 */
public class Problem36 {

    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isPalindromic(String.valueOf(i))
                    && isPalindromic(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        System.out.println("result = " + sum);
    }

    private static boolean isPalindromic(String str) {
        char[] array = str.toCharArray();
        ArrayUtils.reverse(array);
        String s = new String(array);
        return str.equals(s);
    }
}
