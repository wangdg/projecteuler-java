package com.wangdg.projecteuler.level1.problem17;

import java.util.Arrays;

/**
 If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

 If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


 NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 The use of "and" when writing out numbers is in compliance with British usage.
 */
public class Problem17 {

    private static String[] wordArray1 = new String[] {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static String[] wordArray2 = new String[] {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static String[] wordArray3 = new String[] {
            null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            String str = getWord(i);
            System.out.println(str);
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (c != ' ') {
                    sum += 1;
                }
            }
        }
        System.out.println("result = " + sum);
    }

    public static String getWord(int n) {
        if (n < 10) {
            return wordArray1[n - 1];
        } else if (n < 20) {
            return wordArray2[n - 10];
        } else if (n < 100) {
            StringBuffer sb = new StringBuffer();
            sb.append(wordArray3[n / 10 - 1]);
            if (n % 10 != 0) {
                sb.append(" ");
                sb.append(wordArray1[n % 10 - 1]);
            }
            return sb.toString();
        } else if (n == 100) {
            return "one hundred";
        } else if (n < 1000) {
            StringBuffer sb = new StringBuffer();
            sb.append(wordArray1[n / 100 - 1] + " hundred");
            if (n % 100 != 0) {
                sb.append(" and ").append(getWord(n % 100));
            }
            return sb.toString();
        } else {
            return "one thousand";
        }
    }
}
