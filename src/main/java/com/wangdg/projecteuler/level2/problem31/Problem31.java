package com.wangdg.projecteuler.level2.problem31;

/**
 * https://projecteuler.net/problem=31
 */
public class Problem31 {

    public static void main(String[] args) {
        int count = 0;
        for (int c1 = 0; c1 <= 200; c1++) {
            for (int c2 = 0; c2 <= 100; c2++) {
                for (int c5 = 0; c5 <= 40; c5++) {
                    for (int c10 = 0; c10 <= 20; c10++) {
                        for (int c20 = 0; c20 <= 10; c20++) {
                            for (int c50 = 0; c50 <= 4; c50++) {
                                for (int c100 = 0; c100 <= 2; c100++) {
                                    int sum = c1 + c2 * 2 + c5 * 5 + c10 * 10 + c20 * 20 + c50 * 50 + c100 * 100;
                                    if (sum == 200) {
                                        count += 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("result = " + (count + 1));
    }
}
