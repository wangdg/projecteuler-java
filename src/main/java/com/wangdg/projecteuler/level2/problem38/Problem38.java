package com.wangdg.projecteuler.level2.problem38;

import org.apache.commons.lang3.StringUtils;

/**
 * https://projecteuler.net/problem=38
 */
public class Problem38 {

    public static void main(String[] args) {
        long result = 0;
        for (int n = 2; n < 10; n++) {
            int v = 1;
            while (true) {
                String str = getProduct(v, n);
                if (str.length() > 9) {
                    break;
                }
                if (isTargetProduct(str)) {
                    long l = Long.parseLong(str);
                    if (l  > result) {
                        result = l;
                    }
                }
                v += 1;
            }
        }
        System.out.println("result = " + result);
    }

    protected static String getProduct(int v, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(v * i);
        }
        String str = sb.toString();
        return str;
    }

    protected static boolean isTargetProduct(String str) {
        if (str.length() == 9
                && StringUtils.contains(str, '1')
                && StringUtils.contains(str, '2')
                && StringUtils.contains(str, '3')
                && StringUtils.contains(str, '4')
                && StringUtils.contains(str, '5')
                && StringUtils.contains(str, '6')
                && StringUtils.contains(str, '7')
                && StringUtils.contains(str, '8')
                && StringUtils.contains(str, '9')) {
            return true;
        } else {
            return false;
        }
    }
}
