package com.wangdg.projecteuler.level3.problem62;

import java.util.Arrays;

/**
 * https://projecteuler.net/problem=62
 */
public class Problem62 {

    public static void main(String[] args) {
        for (long n1 = 100; n1 < Long.MAX_VALUE; n1++) {
            long t1 = getTopLimit(n1);
            for (long n2 = n1 + 1; n2 <= t1; n2++) {
                if (!isSamePermutation(n1, n2)) continue;
                long t2 = getTopLimit(n2);
                for (long n3 = n2 + 1; n3 <= t2; n3++) {
                    if (!isSamePermutation(n2, n3)) continue;
                    long t3 = getTopLimit(n3);
                    for (long n4 = n3 + 1; n4 <= t3; n4++) {
                        if (!isSamePermutation(n3, n4)) continue;
                        long t4 = getTopLimit(n4);
                        for (long n5 = n4 + 1; n5 <= t4; n5++) {
                            if (!isSamePermutation(n4, n5)) continue;
                            System.out.println(n1 + "^3 = " + (n1 * n1 * n1));
                            System.out.println(n2 + "^3 = " + (n2 * n2 * n2));
                            System.out.println(n3 + "^3 = " + (n3 * n3 * n3));
                            System.out.println(n4 + "^3 = " + (n4 * n4 * n4));
                            System.out.println(n5 + "^3 = " + (n5 * n5 * n5));
                            System.out.println("----------");
                            System.out.println("result = " + (n1 * n1 * n1));
                            return;
                        }
                    }
                }
            }
        }
    }

    private static long getTopLimit(long n) {
        int l = String.valueOf(n).length();
        long product = 1;
        for (int i = 0; i < l; i++) {
            product = 10 * product;
        }
        return product - 1;
    }

    private static boolean isSamePermutation(long n1, long n2) {

        long v1 = n1 * n1 * n1;
        long v2 = n2 * n2 * n2;

        char[] chars1 = String.valueOf(v1).toCharArray();
        char[] chars2 = String.valueOf(v2).toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if (chars1.length != chars2.length) return false;

        int length = chars1.length;
        for (int i = 0; i < length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }

        return true;
    }
}
