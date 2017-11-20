package com.wangdg.projecteuler.level3.problem51;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://projecteuler.net/problem=51
 */
public class Problem51 {

    public static void main(String[] args) {
        int digits = 2;
        while (true) {
            List<Integer> primeList = getPrimes(digits);
            Set<String> patterns = getPatterns(digits, new HashSet<>(primeList));
            for (String pattern : patterns) {
                List<Integer> matchList = primeList.parallelStream()
                        .filter(p -> matchPattern(p, pattern))
                        .collect(Collectors.toList());
                System.out.println(matchList);
                if (matchList.size() == 8) {
                    System.out.println("result = " + matchList);
                    return;
                }
            }

            digits += 1;
        }
    }

    protected static boolean matchPattern(int p, String pattern) {
        String p_str = String.valueOf(p);
        int x = -1;
        int length = pattern.length();
        for (int i = 0; i < length; i++) {
            char pc = pattern.charAt(i);
            char nc = p_str.charAt(i);
            int n = Integer.parseInt(nc + "");
            if (pc == 'x') {
                if (x >= 0) {
                    if (x != n) return false;
                } else {
                    x = n;
                }
            } else {
                int t = Integer.parseInt("" + pc);
                if (t != n) {
                    return false;
                }
            }
        }
        return true;
    }

    protected static Set<String> getPatterns(int digits, Set<Integer> primes) {

        Set<String> simplePatterns = new HashSet<>();
        for (int i = 1; i < digits; i++) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                list.add(1);
            }
            for (int k = 0; k < digits - i; k++) {
                list.add(0);
            }
            PermutationIterator<Integer> iterator = new PermutationIterator<>(list);
            while (iterator.hasNext()) {
                String pattern = iterator.next().stream()
                        .map(n -> String.valueOf(n))
                        .reduce("", (a, s) -> a + s);
                simplePatterns.add(pattern);
            }
        }

        Set<String> patterns = new HashSet<>();
        for (String simplePattern : simplePatterns) {
            for (Integer p : primes) {
                String pStr = p.toString();
                StringBuffer buf = new StringBuffer();
                for (int i = 0; i < digits; i++) {
                    char c = simplePattern.charAt(i);
                    if (c == '1') {
                        buf.append(pStr.charAt(i));
                    } else {
                        buf.append("x");
                    }
                }
                patterns.add(buf.toString());
            }
        }

        return patterns;
    }

    protected static List<Integer> getPrimes(int digits) {
        int p = ArithmeticUtils.pow(10, digits - 1);
        int limit = ArithmeticUtils.pow(10, digits);
        List<Integer> primes = new ArrayList<>();
        while (true) {
            int n = Primes.nextPrime(p + 1);
            if (n < limit) {
                primes.add(n);
                p = n;
            } else {
                break;
            }
        }
        return primes;
    }
}
