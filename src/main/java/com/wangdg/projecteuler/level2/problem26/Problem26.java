package com.wangdg.projecteuler.level2.problem26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

 1/2	= 	0.5
 1/3	= 	0.(3)
 1/4	= 	0.25
 1/5	= 	0.2
 1/6	= 	0.1(6)
 1/7	= 	0.(142857)
 1/8	= 	0.125
 1/9	= 	0.(1)
 1/10	= 	0.1
 Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

 Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Problem26 {

    public static void main(String[] args) {
        int maxLength = 0;
        int result = 0;
        for (int i = 3; i < 1000; i++) {
            int length = getCycleLength(i);
            if (length > maxLength) {
                maxLength = length;
                result = i;
            }
        }
        System.out.println("result = " + result);
    }

    protected static int getCycleLength(int n) {
        List<Integer> modList = new ArrayList<>();
        Set<Integer> modSet = new HashSet<>();
        int temp = 1;
        while (true) {
            int d = temp * 10;
            int mod = d % n;
            if (mod != 0) {
                if (!modSet.contains(mod)) {
                    modSet.add(mod);
                    modList.add(mod);
                    temp = mod;
                } else {
                    int index = modList.indexOf(mod);
                    System.out.println(n + " -> " + (modSet.size() - index));
                    return modSet.size() - index;
                }
            } else {
                System.out.println(n + " -> " + 0);
                return 0;
            }
        }
    }
}
