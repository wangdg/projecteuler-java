package com.wangdg.projecteuler.level1.problem22;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

 What is the total of all the name scores in the file?
 */
public class Problem22 {

    protected static List<Character> LETTER_LIST = new ArrayList<>();
    protected static List<String> WORD_LIST = new ArrayList<>();

    static  {

        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (char c : charArray) {
            LETTER_LIST.add(Character.valueOf(c));
        }

        try {
            String fileContent = IOUtils.toString(Problem22.class.getResourceAsStream("/problem22.txt"), "UTF-8");
            String[] strArray = fileContent.split(",");

            WORD_LIST = Arrays.stream(strArray)
                    .map(str -> StringUtils.replaceChars(str, "\"", ""))
                    .sorted()
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        long sum = 0;

        int size = WORD_LIST.size();
        for (int i = 0; i < size; i++) {
            String name = WORD_LIST.get(i);
            sum += (i + 1) * getLetterScore(name);
        }

        System.out.println("result = " + sum);
    }

    protected static long getLetterScore(String name) {
        int score = 0;
        char[] array = name.toCharArray();
        for (char c : array) {
            score += (LETTER_LIST.indexOf(Character.valueOf(c)) + 1);
        }
        return score;
    }
}
