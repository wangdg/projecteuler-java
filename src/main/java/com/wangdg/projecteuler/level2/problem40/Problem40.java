package com.wangdg.projecteuler.level2.problem40;

/**
 * https://projecteuler.net/problem=40
 */
public class Problem40 {

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer(".");
        for (int i = 1; i <= 1000000; i++) {
            buffer.append(i);
        }

        int product = 1;
        product *= Integer.parseInt(buffer.charAt(1) + "");
        product *= Integer.parseInt(buffer.charAt(10) + "");
        product *= Integer.parseInt(buffer.charAt(100) + "");
        product *= Integer.parseInt(buffer.charAt(1000) + "");
        product *= Integer.parseInt(buffer.charAt(10000) + "");
        product *= Integer.parseInt(buffer.charAt(100000) + "");
        product *= Integer.parseInt(buffer.charAt(1000000) + "");

        System.out.println("result = " + product);
    }
}
