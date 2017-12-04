package com.wangdg.projecteuler.level3.problem53;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class Problem53 {

    public static void main(String[] args) {
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int k = 1; k <= n; k++) {
                try {
                    long v = CombinatoricsUtils.binomialCoefficient(n, k);
                    if (v > 1000000) {
                        count += 1;
                    }
                } catch (MathArithmeticException e) {
                    count += 1;
                }
            }
        }
        System.out.println("result = " + count);
    }
}
