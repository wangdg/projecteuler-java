package com.wangdg.projecteuler.level1.problem4;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

 Find the largest palindrome made from the product of two 3-digit numbers.

 回文数字：正着反着读都一样。9009是2位数字相等最大的回文数字。3位数相乘最大回文数字是多少？

 */
public class Problem4 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 999; i > 99; i--) {
            for (int k = 999; k > 99; k--) {
                int n = i * k;
                if (isPalindromic(n)) {
                    list.add(n);
                }
            }
        }
        Collections.sort(list);
        System.out.println("result = " + list.get(list.size() - 1));
    }

    protected static boolean isPalindromic(int val) {
        String str = String.valueOf(val);
        char[] array = str.toCharArray();
        ArrayUtils.reverse(array);
        String newStr = new String(array);
        return newStr.equals(str);
    }
}
