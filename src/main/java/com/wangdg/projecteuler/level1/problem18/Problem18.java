package com.wangdg.projecteuler.level1.problem18;

import java.util.ArrayList;
import java.util.List;

/**
 https://projecteuler.net/problem=18

 递归解决比较简单

 */
public class Problem18 {


    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        lines.add("75");
        lines.add("95 64");
        lines.add("17 47 82");
        lines.add("18 35 87 10");
        lines.add("20 04 82 47 65");
        lines.add("19 01 23 75 03 34");
        lines.add("88 02 77 73 07 63 67");
        lines.add("99 65 04 28 06 16 70 92");
        lines.add("41 41 26 56 83 40 80 70 33");
        lines.add("41 48 72 33 47 32 37 16 94 29");
        lines.add("53 71 44 65 25 43 91 52 97 51 14");
        lines.add("70 11 33 28 77 73 17 78 39 68 17 57");
        lines.add("91 71 52 38 17 14 91 43 58 50 27 29 48");
        lines.add("63 66 04 68 89 53 67 30 73 16 69 87 40 31");
        lines.add("04 62 98 27 23 09 70 98 73 93 38 53 60 04 23");

        int[][] array = new int[15][];
        for (int i = 0; i < lines.size(); i++) {
            array[i] = new int[i + 1];
            String str = lines.get(i);
            String[] strArray = str.split(" ");
            for (int k = 0; k < strArray.length; k++) {
                array[i][k] = Integer.parseInt(strArray[k]);
            }
        }

        int max = findMaxSum(array, 0, 0, 15);
        System.out.println("result = " + max);
    }

    protected static int findMaxSum(int[][] array, int x, int y, int size) {
        if (size > 1) {

            int leftMax = -1;
            if (x >= 0) {
                leftMax = findMaxSum(array, x, y + 1, size - 1) + array[y][x];
            }

            int rightMax = -1;
            if (x + 1 <= array[y + 1].length) {
                rightMax = findMaxSum(array, x + 1, y + 1, size - 1) + array[y][x];
            }

            return Math.max(leftMax, rightMax);

        } else {
            return array[y][x];
        }
    }
}
