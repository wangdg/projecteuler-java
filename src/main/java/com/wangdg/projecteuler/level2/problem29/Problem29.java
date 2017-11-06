package com.wangdg.projecteuler.level2.problem29;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {

    public static void main(String[] args) {
        Set<BigInteger> numbers = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                BigInteger aa = BigInteger.valueOf(a);
                numbers.add(aa.pow(b));
            }
        }

        System.out.println("result = " + numbers.size());
    }
}
