package com.wangdg.projecteuler.level2.problem35;

import org.apache.commons.math3.primes.Primes;

import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=35
 *
 * 注意：不是数字任意组合，是一个一个头移尾
 */
public class Problem35 {

    public static void main(String[] args) {

        int sum = 0;
        for (int i = 2; i < 1000000; i++) {
            if (isTargetPrime(i)) {
                sum += 1;
            }
        }

        System.out.println("result = " + sum);
    }

    protected static boolean isTargetPrime(int n) {
        if (Primes.isPrime(n)) {

            List<String> digitStringList = new ArrayList<>();
            char[] chars = String.valueOf(n).toCharArray();
            for (char c : chars) {
                digitStringList.add("" + c);
            }

            int size = digitStringList.size();
            for (int i = 0; i < size; i++) {
                String l = digitStringList.get(size - 1);
                digitStringList.remove(size - 1);
                digitStringList.add(0, l);

                String str = digitStringList.stream()
                        .reduce("", (a, s) -> a + s);

                if (!Primes.isPrime(Integer.parseInt(str))) {
                    return false;
                }
            }

            System.out.println("find " + n);

            return true;

        } else {
            return false;
        }
    }
}
