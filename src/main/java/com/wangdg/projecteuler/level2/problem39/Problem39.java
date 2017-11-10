package com.wangdg.projecteuler.level2.problem39;

/**
 * https://projecteuler.net/problem=39
 */
public class Problem39 {

    public static void main(String[] args) {

        int maxCount = 0;
        int maxP = 1;
        for (int p = 1; p <= 1000; p++) {
            int count = getCount(p);
            if (count > maxCount) {
                maxCount = count;
                maxP = p;
            }
        }
        System.out.println("result = " + maxP);
    }

    protected static int getCount(int p) {
        int count = 0;
        for (int a = 1; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                int c = p - a - b;
                if (c <= 0) continue;
                if (a * a + b * b == c * c) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
