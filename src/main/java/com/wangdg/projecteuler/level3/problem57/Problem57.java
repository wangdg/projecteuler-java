package com.wangdg.projecteuler.level3.problem57;

import org.apache.commons.math3.fraction.BigFraction;

/**
 * https://projecteuler.net/problem=57
 */
public class Problem57 {

    public static void main(String[] args) {
        int result = 0;
        BigFraction f = BigFraction.getReducedFraction(1, 2);
        int count = 0;
        do  {
            BigFraction s = BigFraction.ONE.add(f);
            int n = String.valueOf(s.getNumerator()).length();
            int d = String.valueOf(s.getDenominator()).length();
            if (n > d) {
                result += 1;
            }
            f = getNextFraction(f);
            count += 1;
        } while (count <= 1000);
        System.out.println("result = " + result);
    }

    private static BigFraction getNextFraction(BigFraction f) {
        BigFraction ret = f.add(BigFraction.TWO);
        return BigFraction.ONE.divide(ret);
    }
}
