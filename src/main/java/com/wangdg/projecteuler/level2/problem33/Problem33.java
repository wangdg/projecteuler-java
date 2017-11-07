package com.wangdg.projecteuler.level2.problem33;

import org.apache.commons.lang3.math.Fraction;

import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=33
 */
public class Problem33 {

    public static void main(String[] args) {

        Set<Fraction> fractions = new HashSet<>();

        for (int i = 10; i < 100; i++) {
            if (isSkipNumber(i)) continue;
            for (int k = i + 1; k < 100; k++) {
                if (isSkipNumber(k)) continue;
                if (isCurious(i, k)) {
                    fractions.add(Fraction.getFraction(i, k));
                }
            }
        }

        Fraction product = fractions.stream()
                .reduce(Fraction.ONE, (a, v) -> a.multiplyBy(v))
                .reduce();

        System.out.println("result = " + product.getDenominator());

    }

    protected static boolean isSkipNumber(int n) {
        if (n % 10 == 0 || n % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    protected static boolean isCurious(int n1, int n2) {

        int n = Math.min(n1, n2);
        int d = Math.max(n1, n2);

        Set<Integer> nSet = new HashSet<>();
        nSet.add(n / 10);
        nSet.add(n % 10);

        Set<Integer> dSet = new HashSet<>();
        dSet.add(d / 10);
        dSet.add(d % 10);

        nSet.retainAll(dSet);
        if (nSet.size() != 1) {
            return false;
        }

        String str = nSet.iterator().next().toString();

        int nn = Integer.parseInt(String.valueOf(n).replace(str, ""));
        int dd = Integer.parseInt(String.valueOf(d).replace(str, ""));

        Fraction f1 = Fraction.getFraction(n, d).reduce();
        Fraction f2 = Fraction.getFraction(nn, dd).reduce();
        if (f1.equals(f2)) {
            System.out.println(String.format("%d / %d", n, d));
            return true;
        } else {
            return false;
        }
    }
}
