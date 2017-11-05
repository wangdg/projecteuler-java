package com.wangdg.projecteuler.level2.problem28;

/**
 https://projecteuler.net/problem=28
 */
public class Problem28 {

    public static void main(String[] args) {
        int[][] array = new int[1001][1001];
        fillDataToArray(array);
        System.out.println("result = " + getSum(array));
    }

    protected static void fillDataToArray(int[][] array) {

        int centerX = array.length / 2;
        int centerY = array.length / 2;
        array[centerX][centerY] = 1;

        int currentX = centerX;
        int currentY = centerY;

        int currentValue = 1;

        int radius = 0;

        while (true) {

            // move right
            currentX += 1;
            if (currentX >= array.length) {
                break;
            }
            array[currentX][currentY] = ++currentValue;

            // radius
            radius += 1;

            // move down
            for (int i = 0; i < radius * 2 - 1; i++) {
                currentY += 1;
                array[currentX][currentY] = ++currentValue;
            }

            // move left
            for (int i = 0; i < radius * 2; i++) {
                currentX -= 1;
                array[currentX][currentY] = ++currentValue;
            }

            // move up
            for (int i = 0; i < radius * 2; i++) {
                currentY -= 1;
                array[currentX][currentY] = ++currentValue;
            }

            // move right
            for (int i = 0; i < radius * 2; i++) {
                currentX += 1;
                array[currentX][currentY] = ++currentValue;
            }
        }
    }

    protected static long getSum(int[][] array) {

        int l = array.length;

        int sum1 = 0;
        for (int i = 0; i < l; i++) {
            sum1 += array[i][i];
        }

        int sum2 = 0;
        for (int i = 0; i < l; i++) {
            sum2 += array[l - i - 1][i];
        }

        return sum1 + sum2 - 1;
    }
}
