package com.wangdg.projecteuler.level1.problem14;

/**
 The following iterative sequence is defined for the set of positive integers:

 n → n/2 (n is even)
 n → 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:

 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?

 NOTE: Once the chain starts the terms are allowed to go above one million.

 Collatz猜想

 注意溢出的问题。

 */
public class Problem14 {

    public static void main(String[] args) {
        long maxLength = 0;
        int result = 0;
        for (int i = 1; i <= 1000000; i++) {
            long length = getCollatzLength(i);
            if (length > maxLength) {
                maxLength = length;
                result = i;
            }
        }
        System.out.println("result = " + result);
    }

    public static long getCollatzLength(int n) {
        long v = n;
        long result = 1;
        while (v != 1) {
            if (v % 2 == 0) {
                v = v / 2;
            } else {
                v = 3 * v + 1;
            }
            result++;
        }
        return result;
    }
}
