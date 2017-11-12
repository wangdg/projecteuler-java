package com.wangdg.projecteuler.level2.problem42;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=42
 */
public class Problem42 {

    protected static String LETTER_STR = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        Set<String> words = readWords();
        int sum = 0;
        for (String word : words) {
            int val = getWordValue(word);
            if (isTriangleNumber(val)) {
                sum += 1;
            }
        }
        System.out.println("result = " + sum);
    }

    protected static boolean isTriangleNumber(int n) {
        int nn = n * 2;
        int limit = (int)Math.sqrt(nn) + 1;
        for (int i = 1; i <= limit; i++) {
            if (nn % i == 0 && (i + 1 == nn / i)) {
                return true;
            }
        }
        return false;
    }

    protected static int getWordValue(String str) {
        char[] chars = str.toCharArray();
        int val = 0;
        for (char c : chars) {
            val += (LETTER_STR.indexOf(c) + 1);
        }
        return val;
    }

    protected static Set<String> readWords() {
        try {
            String str = IOUtils.toString(Problem42.class.getResourceAsStream("/problem42.txt"), "UTF-8");
            String[] array = str.split(",");
            Set<String> words = new HashSet<>();
            for (String word : array) {
                words.add(word.replace("\"", "").toLowerCase());
            }
            return words;
        } catch (IOException e) {
            return null;
        }
    }
}
