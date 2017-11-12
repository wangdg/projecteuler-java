package com.wangdg.projecteuler.level2.problem43;

import org.apache.commons.collections4.iterators.PermutationIterator;

import java.util.HashSet;
import java.util.Set;

public class Problem43 {

    public static void main(String[] args) {

        Set<Integer> digits = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        long sum = 0;

        PermutationIterator<Integer> iterator = new PermutationIterator<>(digits);
        while (iterator.hasNext()) {
            String str = iterator.next().stream()
                    .map(i -> i.toString())
                    .reduce("", (a, s) -> a + s);
            if (isTarget(str)) {
                sum += Long.parseLong(str);
            }
        }

        System.out.println("result = " + sum);
    }

    protected static boolean isTarget(String str) {
        if (Integer.parseInt(str.substring(1, 4)) % 2 != 0) {
            return false;
        }
        if (Integer.parseInt(str.substring(2, 5)) % 3 != 0) {
            return false;
        }
        if (Integer.parseInt(str.substring(3, 6)) % 5 != 0) {
            return false;
        }
        if (Integer.parseInt(str.substring(4, 7)) % 7 != 0) {
            return false;
        }
        if (Integer.parseInt(str.substring(5, 8)) % 11 != 0) {
            return false;
        }
        if (Integer.parseInt(str.substring(6, 9)) % 13 != 0) {
            return false;
        }
        if (Integer.parseInt(str.substring(7, 10)) % 17 != 0) {
            return false;
        }
        return true;
    }
}
