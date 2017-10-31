package com.wangdg.projecteuler.level1.problem19;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 You are given the following information, but you may prefer to do some research for yourself.

 1 Jan 1900 was a Monday.
 Thirty days has September,
 April, June and November.
 All the rest have thirty-one,
 Saving February alone,
 Which has twenty-eight, rain or shine.
 And on leap years, twenty-nine.
 A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

 有多少月第一天是周日

 */
public class Problem19 {

    public static void main(String[] args) {

        int sum = 0;

        Calendar calendar = new GregorianCalendar();
        calendar.set(1901, 1, 1);
        while (calendar.get(Calendar.YEAR) <= 2000) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sum += 1;
            }
            calendar.add(Calendar.MONTH, 1);
        }

        System.out.println("result = " + sum);
    }
}
