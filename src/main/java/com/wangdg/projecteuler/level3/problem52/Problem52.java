package com.wangdg.projecteuler.level3.problem52;

import java.util.Arrays;

/**
 * https://projecteuler.net/problem=52
 */
public class Problem52 {

    public static void main(String[] args) {
        int x = 1;
        while (true) {
            int x2 = 2 * x;
            int x3 = 3 * x;
            int x4 = 4 * x;
            int x5 = 5 * x;
            int x6 = 6 * x;
            if (isTarget(x, x2, x3, x4, x5, x6)) {
                System.out.println("result = " + x);
                return;
            } else {
                x += 1;
            }
        }
    }

    protected static boolean isTarget(int... numbers) {
        String str = getCharSortedString(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            String str_n = getCharSortedString(numbers[i]);
            if (!str_n.equals(str)) {
                return false;
            }
        }
        return true;
    }

    protected static String getCharSortedString(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
