package com.wangdg.projecteuler.level3.problem54;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Problem54 {

    /**
     * Card类：代表一张牌
     */
    private static class Card implements Comparable {

        private Integer value;
        private String suit;

        public Card(String str) {
            char[] chars = str.toCharArray();
            if (StringUtils.isNumeric("" + chars[0])) {
                value = Integer.parseInt("" + chars[0]);
            } else {
                if (chars[0] == 'T') {
                    value = 10;
                } else if (chars[0] == 'J') {
                    value = 11;
                } else if (chars[0] == 'Q') {
                    value = 12;
                } else if (chars[0] == 'K') {
                    value = 13;
                } else if (chars[0] == 'A') {
                    value = 14;
                }
            }
            suit = "" + chars[1];
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        @Override
        public int compareTo(Object o) {
            Card card = (Card) o;
            if (this.value > card.getValue()) {
                return 1;
            } else if (this.value < card.getValue()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Player类：代表玩家手里的牌
     */
    private static class Player implements Comparable {

        private Set<Card> cards = new HashSet<>();

        private List<Card> sortedList;
        private Map<Integer, Integer> valueStatMap;

        private Boolean isSameSuit;
        private Boolean isRoyalFlush;
        private Boolean isStraightFlush;
        private Boolean isFourOfAKind;
        private Boolean isFullHouse;
        private Boolean isFlush;
        private Boolean isStraight;
        private Boolean isThreeOfAKind;
        private Boolean isTwoPairs;
        private Boolean isOnePair;

        public void addCard(Card card) {
            cards.add(card);
        }

        public Set<Card> getCards() {
            return cards;
        }

        public List<Card> getSortedList() {
            if (sortedList == null) {
                sortedList = this.getCards().stream()
                        .sorted(Card::compareTo)
                        .collect(Collectors.toList());
            }
            return sortedList;
        }

        public Integer getMaxCardValue() {

            List<Card> sortedList = getSortedList();
            int size = sortedList.size();
            Card theWholeMax = sortedList.get(size - 1);

            if (isRoyalFlush()) {
                return theWholeMax.getValue();
            } else if (isStraightFlush()) {
                return theWholeMax.getValue();
            } else if (isFourOfAKind()) {
                Integer v1 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() == 4)
                        .map(e -> e.getKey())
                        .collect(Collectors.toSet())
                        .iterator().next();
                Integer v2 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() != 4)
                        .map(e -> e.getKey())
                        .collect(Collectors.toSet())
                        .iterator().next();
                return v1 * 100 + v2;
            } else if (isFullHouse()) {
                Integer v1 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() == 3)
                        .map(e -> e.getKey())
                        .collect(Collectors.toSet())
                        .iterator().next();
                Integer v2 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() == 2)
                        .map(e -> e.getKey())
                        .collect(Collectors.toSet())
                        .iterator().next();
                return v1 * 100 + v2;
            } else if (isFlush()) {
                return theWholeMax.getValue();
            } else if (isStraight()) {
                return theWholeMax.getValue();
            } else if (isThreeOfAKind()) {
                Integer v1 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() == 3)
                        .map(e -> e.getKey())
                        .collect(Collectors.toSet())
                        .iterator().next();
                Integer v2 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() != 3)
                        .map(e -> e.getKey())
                        .max(Comparator.comparingInt(Integer::intValue)).get();
                return v1 * 100 + v2;
            } else if (isTwoPairs()) {
                List<Integer> list = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() == 2)
                        .map(e -> e.getKey())
                        .sorted()
                        .collect(Collectors.toList());
                Integer v1 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() == 1)
                        .map(e -> e.getKey())
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList()).iterator().next();
                return list.get(1) * 10000 + list.get(0) * 100 + v1;
            } else if (isOnePair()) {
                Integer v1 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() == 2)
                        .map(e -> e.getKey())
                        .max(Comparator.comparingInt(Integer::intValue)).get();
                Integer v2 = getValueStatMap().entrySet().stream()
                        .filter(e -> e.getValue() != 2)
                        .map(e -> e.getKey())
                        .max(Comparator.comparingInt(Integer::intValue)).get();
                return v1 * 100 + v2;
            } else {
                return theWholeMax.getValue();
            }
        }

        public Map<Integer, Integer> getValueStatMap() {
            if (valueStatMap == null) {
                valueStatMap = new HashMap<>();
                for (Card card : cards) {
                    if (valueStatMap.containsKey(card.getValue())) {
                        Integer val = valueStatMap.get(card.getValue());
                        valueStatMap.put(card.getValue(), val + 1);
                    } else {
                        valueStatMap.put(card.getValue(), 1);
                    }
                }
            }
            return valueStatMap;
        }

        public boolean isSameSuit() {
            if (isSameSuit == null) {
                Set<String> suits = cards.stream().map(Card::getSuit).collect(Collectors.toSet());
                isSameSuit = suits.size() == 1;
            }
            return isSameSuit;
        }

        public boolean isRoyalFlush() {
            if (isRoyalFlush == null) {
                List<Card> list = getSortedList();
                if (isSameSuit()) {
                    if (list.get(0).getValue() == 11
                            && list.get(1).getValue() == 12
                            && list.get(2).getValue() == 13
                            && list.get(3).getValue() == 14
                            && list.get(4).getValue() == 15) {
                        isRoyalFlush = true;
                    } else {
                        isRoyalFlush = false;
                    }
                } else {
                    isRoyalFlush = false;
                }
            }
            return isRoyalFlush;
        }

        public boolean isStraightFlush() {
            if (isStraightFlush == null) {
                List<Card> list = getSortedList();
                if (isSameSuit()) {
                    int val = list.get(0).getValue();
                    if (list.get(1).getValue() == val + 1
                            && list.get(2).getValue() == val + 2
                            && list.get(3).getValue() == val + 3
                            && list.get(4).getValue() == val + 4) {
                        isStraightFlush = true;
                    } else {
                        isStraightFlush = false;
                    }
                } else {
                    isStraightFlush = false;
                }
            }

            return isStraightFlush;
        }

        public boolean isFourOfAKind() {
            if (isFourOfAKind == null) {
                Map<Integer, Integer> statMap = getValueStatMap();
                Collection<Integer> mapValues = statMap.values();
                for (Integer mapVal : mapValues) {
                    if (mapVal == 4) {
                        isFourOfAKind = true;
                        break;
                    }
                }
                if (isFourOfAKind == null) {
                    isFourOfAKind = false;
                }
            }
            return isFourOfAKind;
        }

        public boolean isFullHouse() {
            if (isFullHouse == null) {
                Map<Integer, Integer> statMap = getValueStatMap();
                if (statMap.keySet().size() == 2) {
                    Integer count = statMap.values().iterator().next();
                    if (count == 2 || count == 3) {
                        isFullHouse = true;
                    } else {
                        isFullHouse = false;
                    }
                } else {
                    isFullHouse = false;
                }
            }
            return isFullHouse;
        }

        public boolean isFlush() {
            if (isFlush == null) {
                isFlush = isSameSuit();
            }
            return isFlush;
        }

        public boolean isStraight() {
            if (isStraight == null) {
                List<Card> sortedList = this.getSortedList();
                int size = sortedList.size();
                for (int i = 0; i < size - 1; i++) {
                    int v1 = sortedList.get(i).getValue();
                    int v2 = sortedList.get(i + 1).getValue();
                    if (v2 - v1 != 1) {
                        isStraight = false;
                        break;
                    }
                }
                if (isStraight == null) {
                    isStraight = true;
                }
            }
            return isStraight;
        }

        public boolean isThreeOfAKind() {
            if (isThreeOfAKind == null) {
                Map<Integer, Integer> statMap = getValueStatMap();
                if (statMap.keySet().size() == 3) {
                    long count = statMap.values().stream().filter(v -> v == 3).count();
                    isThreeOfAKind = count == 1;
                } else {
                    isThreeOfAKind = false;
                }
            }
            return isThreeOfAKind;
        }

        public boolean isTwoPairs() {
            if (isTwoPairs == null) {
                Map<Integer, Integer> statMap = getValueStatMap();
                long count1 = statMap.values().stream().filter(v -> v == 2).count();
                isTwoPairs = count1 == 2;
            }
            return isTwoPairs;
        }

        public boolean isOnePair() {
            if (isOnePair == null) {
                Map<Integer, Integer> statMap = getValueStatMap();
                long count1 = statMap.values().stream().filter(v -> v == 2).count();
                long count2 = statMap.values().stream().filter(v -> v == 1).count();
                if (count1 == 1 && count2 == 3) {
                    isOnePair = true;
                } else {
                    isOnePair = false;
                }
            }
            return isOnePair;
        }

        public int getLevel() {
            if (isRoyalFlush()) {
                return 10;
            } else if (isStraightFlush()) {
                return 9;
            } else if (isFourOfAKind()) {
                return 8;
            } else if (isFullHouse()) {
                return 7;
            } else if (isFlush()) {
                return 6;
            } else if (isStraight()) {
                return 5;
            } else if (isThreeOfAKind()) {
                return 4;
            } else if (isTwoPairs()) {
                return 3;
            } else if (isOnePair()) {
                return 2;
            } else {
                return 1;
            }
        }

        /**
         * 比大小
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
            Player player = (Player) o;
            int l1 = this.getLevel();
            int l2 = player.getLevel();
            if (l1 < l2) {
                return -1;
            } else if (l1 > l2) {
                return 1;
            } else {
                Integer v1 = this.getMaxCardValue();
                Integer v2 = player.getMaxCardValue();
                return v1.compareTo(v2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        List<String> lines = IOUtils.readLines(Problem54.class.getResourceAsStream("/problem54.txt"), "UTF-8");
        for (String line : lines) {
            String[] array = line.split(" ");

            Player p1 = new Player();
            p1.addCard(new Card(array[0]));
            p1.addCard(new Card(array[1]));
            p1.addCard(new Card(array[2]));
            p1.addCard(new Card(array[3]));
            p1.addCard(new Card(array[4]));

            Player p2 = new Player();
            p2.addCard(new Card(array[5]));
            p2.addCard(new Card(array[6]));
            p2.addCard(new Card(array[7]));
            p2.addCard(new Card(array[8]));
            p2.addCard(new Card(array[9]));

            if (p1.compareTo(p2) > 0) {
                count += 1;
            } else if (p1.compareTo(p2) == 0) {
                System.out.println(line);
            }
        }

        System.out.println("result = " + count);
    }
}
