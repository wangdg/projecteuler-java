package com.wangdg.projecteuler.level1.problem09;

/**
 A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

 a2 + b2 = c2
 For example, 32 + 42 = 9 + 16 = 25 = 52.

 There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 Find the product abc.

 a,b,c是勾股数

 */
public class Problem9 {

    public static void main(String[] args) {
        for (int a = 1; a <= 1000; a++) {
            for (int b = 1; b <= 1000; b++) {
                int c = 1000 - (a + b);
                if (isPythagorean(a, b, c)) {
                    System.out.println("result = " + a * b * c);
                    return;
                }
            }
        }
    }

    protected static boolean isPythagorean(int a, int b, int c) {
        return c * c == a * a + b * b;
    }
}
