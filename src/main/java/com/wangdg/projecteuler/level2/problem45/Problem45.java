package com.wangdg.projecteuler.level2.problem45;

/**
 * https://projecteuler.net/problem=45
 */
public class Problem45 {

    public static void main(String[] args) {
        long i = 285;
        while (true) {
            long t = getTriangle(i);
            if (isPentagonal(t) && isHexagonal(t)) {
                System.out.println("result = " + t);
                return;
            }
            i += 1;
        }
    }

    protected static long getTriangle(long n) {
        return n * (n + 1) / 2;
    }

    protected static boolean isPentagonal(long n) {
        double v = (Math.sqrt(24 * n + 1) + 1.0) / 6.0;
        return v == (long)v;
    }

    protected static boolean isHexagonal(long n) {
        double v = (Math.sqrt(8 * n + 1) + 1.0) / 6.0;
        return v == (long)v;
    }
}
