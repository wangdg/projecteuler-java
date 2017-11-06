package com.wangdg.projecteuler.level2.problem32;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.*;

/**
 * https://projecteuler.net/problem=32
 */
public class Problem32 {

    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        Set<Long> targets = new HashSet<>();

        PermutationIterator<Integer> permutationIterator = new PermutationIterator<>(numbers);
        permutationIterator.forEachRemaining(list -> {
            Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(8, 2);
            iterator.forEachRemaining(combineArray -> {
                Long p = getProduct(list, combineArray);
                if (p != null) {
                    targets.add(p);
                }
            });
        });

        long sum = targets.stream()
                .mapToLong(Long::longValue)
                .sum();

        System.out.println("result = " + sum);
    }

    protected static Long getProduct(List<Integer> arrange, int[] combineArray) {
        int size = arrange.size();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(arrange.get(i).toString());
            if (ArrayUtils.contains(combineArray, i)) {
                sb.append(",");
            }
        }
        String[] strArray = sb.toString().split(",");
        long p1 = Long.parseLong(strArray[0]);
        long p2 = Long.parseLong(strArray[1]);
        long r = Long.parseLong(strArray[2]);
        if (r == p1 * p2) {
            return r;
        } else {
            return null;
        }
    }
}
