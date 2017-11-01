package com.wangdg.projecteuler.level1.problem25;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=25
 */
public class Problem25 {

    private static List<BigInteger> list = new ArrayList<>();

    static {
        list.add(BigInteger.ONE);
        list.add(BigInteger.ONE);
    }

    public static void main(String[] args) {
        int index = 0;
        while (true) {
            BigInteger n = fibonacci(index + 1);
            if (n.toString().length() >= 1000) {
                break;
            } else {
                index++;
            }
        }
        System.out.println("result = " + (index + 1));
    }

    protected static BigInteger fibonacci(int n) {
        if (list.size() >= n) {
            return list.get(n - 1);
        }
        BigInteger result = fibonacci(n - 2).add(fibonacci(n - 1));
        list.add(result);
        return result;
    }
}
