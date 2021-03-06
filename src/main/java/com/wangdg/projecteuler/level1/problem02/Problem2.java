package com.wangdg.projecteuler.level1.problem02;

import java.util.ArrayList;
import java.util.List;

/**
 Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

 By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        while (true) {

            int n1 = list.get(list.size() - 1);
            if (n1 > 4000000) {
                break;
            }

            int n2 = list.get(list.size() - 2);
            list.add(n1 + n2);
        }

        long sum = 0;
        for (Integer i : list) {
            if (i % 2 == 0) sum += i;
        }

        System.out.println(sum);
    }
}
