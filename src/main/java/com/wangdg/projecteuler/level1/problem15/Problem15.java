package com.wangdg.projecteuler.level1.problem15;

import org.apache.commons.math3.util.CombinatoricsUtils;

/**
 URL: https://projecteuler.net/problem=15

 归结为排列组合的问题。40个球的排列，除以20!*20!, 但是数据量太大了。

 最好的思路：40选20

 */
public class Problem15 {

    public static void main(String[] args) {
        System.out.println("result = " + CombinatoricsUtils.binomialCoefficient(40, 20));
    }
}
