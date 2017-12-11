package com.wangdg.projecteuler.level3.problem55;

import org.apache.commons.lang3.ArrayUtils;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=55
 */
public class Problem55 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            BigInteger integer = BigInteger.valueOf(i);
            boolean isLychrel = true;
            for (int j = 0; j < 49; j++) {
                integer = integer.add(getReverseInteger(integer));
                if (isPalindrome(integer)) {
                    isLychrel = false;
                    break;
                }
            }
            if (isLychrel) {
                sum += 1;
            }
        }
        System.out.println("result = " + sum);
    }

    private static BigInteger getReverseInteger(BigInteger integer) {
        char[] charArray = integer.toString().toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return new BigInteger(sb.toString());
    }

    private static boolean isPalindrome(BigInteger integer) {
        String str = integer.toString();
        char[] array = str.toCharArray();
        ArrayUtils.reverse(array);
        String newStr = new String(array);
        return newStr.equals(str);
    }
}
