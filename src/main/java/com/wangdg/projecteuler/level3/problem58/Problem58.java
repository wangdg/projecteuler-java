package com.wangdg.projecteuler.level3.problem58;

import org.apache.commons.math3.primes.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=58
 */
public class Problem58 {

    private static class Block {

        private int index = 1;

        private int lt = 5;
        private int rt = 3;
        private int lb = 7;
        private int rb = 9;

        private Set<Integer> diagonals = new HashSet<>();
        private Set<Integer> primes = new HashSet<>();

        public Block() {
            diagonals.add(5);
            diagonals.add(3);
            diagonals.add(7);
            diagonals.add(9);
            diagonals.add(1);

            primes.add(5);
            primes.add(3);
            primes.add(7);
        }

        public void next() {

            index += 1;
            int length = 2 * index + 1;

            rt = (rb + 1) + (length - 2);
            lt = rt + length - 1;
            lb = lt + length - 1;
            rb = lb + length - 1;

            diagonals.add(lt);
            diagonals.add(rt);
            diagonals.add(lb);
            diagonals.add(rb);

            if (Primes.isPrime(lt)) {
                primes.add(lt);
            }
            if (Primes.isPrime(rt)) {
                primes.add(rt);
            }
            if (Primes.isPrime(lb)) {
                primes.add(lb);
            }
            if (Primes.isPrime(rb)) {
                primes.add(rb);
            }
        }

        public int getLength() {
            return 2 * index + 1;
        }

        public float getRate() {
            return (1.0f * primes.size()) / diagonals.size();
        }
    }

    private static int[][] lastArray = null;

    public static void main(String[] args) {
        Block block = new Block();
        while (true) {
            float rate = block.getRate();
            System.out.println("rate = " + rate);
            if (rate < 0.1f) {
                System.out.println("result = " + block.getLength());
                break;
            } else {
                block.next();
            }
        }
    }
}
