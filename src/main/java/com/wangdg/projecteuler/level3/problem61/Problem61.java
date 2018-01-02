package com.wangdg.projecteuler.level3.problem61;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://projecteuler.net/problem=61
 */
public class Problem61 {

    private static class FigurateNumber {

        public static FigurateNumber create(int type, int val) {
            FigurateNumber n = new FigurateNumber();
            n.setType(type);
            n.setNumber(val);
            return n;
        }

        private Integer number;

        private int type;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static void main(String[] args) {

        Set<FigurateNumber> numbers = getNumbers();
        List<FigurateNumber> numberList = numbers.stream()
                .sorted(Comparator.comparingInt(FigurateNumber::getNumber))
                .collect(Collectors.toList());

        for (FigurateNumber n1 : numberList) {
            for (FigurateNumber n2 : numberList) {
                if (n1 == n2) continue;
                if (n1.getType() == n2.getType()) continue;
                if (n1.getNumber() % 100 != n2.getNumber() / 100) continue;
                for (FigurateNumber n3 : numberList) {
                    if (n1 == n3 || n2 == n3) continue;
                    if (n1.getType() == n3.getType() || n2.getType() == n3.getType()) continue;
                    if (n2.getNumber() % 100 != n3.getNumber() / 100) continue;
                    for (FigurateNumber n4 : numberList) {
                        if (n1 == n4 || n2 == n4 || n3 == n4) continue;
                        if (n1.getType() == n4.getType() || n2.getType() == n4.getType() || n3.getType() == n4.getType()) continue;
                        if (n3.getNumber() % 100 != n4.getNumber() / 100) continue;
                        for (FigurateNumber n5 : numberList) {
                            if (n1 == n5 || n2 == n5 || n3 == n5 || n4 == n5) continue;
                            if (n1.getType() == n5.getType() || n2.getType() == n5.getType() || n3.getType() == n5.getType() || n4.getType() == n5.getType()) continue;
                            if (n4.getNumber() % 100 != n5.getNumber() / 100) continue;
                            for (FigurateNumber n6 : numberList) {
                                if (n1 == n6 || n2 == n6 || n3 == n6 || n4 == n6 || n5 == n6) continue;
                                if (n1.getType() == n6.getType() || n2.getType() == n6.getType() || n3.getType() == n6.getType() || n4.getType() == n6.getType() || n5.getType() == n6.getType()) continue;
                                if (n5.getNumber() % 100 != n6.getNumber() / 100) continue;
                                if (n6.getNumber() % 100 != n1.getNumber() / 100) continue;
                                System.out.println("result = " + (n1.getNumber() + n2.getNumber() + n3.getNumber() + n4.getNumber() + n5.getNumber() + n6.getNumber()));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static Set<FigurateNumber> getNumbers() {

        Set<FigurateNumber> numbers = new HashSet<>();

        int n = 1;
        while (true) {
            int triangle = n * (n + 1) / 2;
            if (String.valueOf(triangle).length() == 4) {
                numbers.add(FigurateNumber.create(3, triangle));
            }

            int square = n * n;
            if (String.valueOf(square).length() == 4) {
                numbers.add(FigurateNumber.create(4, square));
            }

            int pentagonal = n * (3 * n - 1) / 2;
            if (String.valueOf(pentagonal).length() == 4) {
                numbers.add(FigurateNumber.create(5, pentagonal));
            }

            int hexagonal = n * (2 * n - 1);
            if (String.valueOf(hexagonal).length() == 4) {
                numbers.add(FigurateNumber.create(6, hexagonal));
            }

            int heptagonal = n * (5 * n - 3) / 2;
            if (String.valueOf(heptagonal).length() == 4) {
                numbers.add(FigurateNumber.create(7, heptagonal));
            }

            int octagonal = n * (3 * n - 2);
            if (String.valueOf(octagonal).length() == 4) {
                numbers.add(FigurateNumber.create(8, octagonal));
            }

            if (String.valueOf(triangle).length() > 4
                    && String.valueOf(square).length() > 4
                    && String.valueOf(pentagonal).length() > 4
                    && String.valueOf(hexagonal).length() > 4
                    && String.valueOf(heptagonal).length() > 4
                    && String.valueOf(octagonal).length() > 4) {
                break;
            }

            n += 1;
        }

        return numbers;
    }
}
