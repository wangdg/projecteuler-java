package com.wangdg.projecteuler.level1.problem24;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.ArrayList;
import java.util.List;

/**
 A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

 012   021   102   120   201   210

 What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?


 有序的排列问题：要给排序编号

 先从小到大确定第一个位置的元素，同时计排列个数，排列个数如果大于100万，就确定了一位。

 剩下的数重复步骤即可。

 */
public class Problem24 {

    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        int limit = 1000000;
        while (numbers.size() > 1) {
            limit -= removeFirstNumber(numbers, limit);
        }

        resultList.add(numbers.get(0));

        String result = resultList.stream()
                .map(v -> v.toString())
                .reduce("", (a, v) -> a + v);

        System.out.println("result = " + result);
    }

    /**
     * 取得第一位数字的Index
     *
     * @param numbers
     * @param limit
     * @return
     */
    protected static long removeFirstNumber(List<Integer> numbers, int limit) {
        int size = numbers.size();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            long factorial = CombinatoricsUtils.factorial(size - 1);
            long temp = sum + factorial;
            if (temp >= limit) {
                resultList.add(numbers.get(i));
                numbers.remove(i);
                break;
            } else {
                sum += factorial;
            }
        }
        return sum;
    }
}
