package com.wangdg.projecteuler.level2.problem44;

/**
 * https://projecteuler.net/problem=44
 */
public class Problem44 {

    public static void main(String[] args) {
        int i = 2;
        while (true) {
            int p1 = getPentagonal(i);
            for (int j = i - 1; j > 0; j--) {
                int p2 = getPentagonal(j);
                if (isPentagonal(p1 + p2) && isPentagonal(p1 - p2)) {
                    System.out.println("result = " + (p1 - p2));
                    return;
                }
            }
            i += 1;
        }
    }

    protected static boolean isPentagonal(int n) {
        double v = (Math.sqrt(24 * n + 1) + 1.0) / 6.0;
        return v == (int)v;
    }

    protected static int getPentagonal(int n) {
        return n * (3 * n - 1) / 2;
    }
}
