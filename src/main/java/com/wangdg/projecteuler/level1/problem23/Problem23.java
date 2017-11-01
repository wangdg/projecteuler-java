package com.wangdg.projecteuler.level1.problem23;

import java.util.HashSet;
import java.util.Set;

/**
 A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

 As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis,
 it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

 真因数的和与原数比：
 小于：deficient
 等于：perfect
 大于：abundant

 12是最小的abundant数，能写成2个abundant数的和，最小数是24

 数学分析显示：所有大于28123的整数可以写成2个abundant数的和。

 找出所有28123以下这样的数：不能写成两个abundant数的和

 求它们的和

 */
public class Problem23 {

    // all abundant numbers
    private static Set<Integer> allAbundantNumbers = findAllAbundantNumbers();

    public static void main(String[] args) {

        long sum = 0;

        for (int i = 1; i <= 28123; i++ ) {
            if (!isCombinedOfAbundant(i)) {
                sum += i;
            }
        }

        System.out.println("result = " + sum);
    }

    protected static boolean isCombinedOfAbundant(int n) {
        for (Integer i : allAbundantNumbers) {
            int a = n - i;
            if (allAbundantNumbers.contains(a)) {
                return true;
            }
        }
        return false;
    }

    protected static Set<Integer> findAllAbundantNumbers() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 28123; i++ ) {
            if (i < getSumOfProperDivisors(i)) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    protected static int getSumOfProperDivisors(int n) {
        int size = n / 2 + 1;
        int sum = 0;
        for (int i = 1; i <= size; i++) {
            if (n % i == 0 && n != i) {
                sum += i;
            }
        }
        return sum;
    }
}
