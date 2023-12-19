package com.balodza;

import java.util.StringJoiner;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        try {
            final TreeMap<Key, String> map = new TreeMap<>();
            map.put(new Key(), "One");
            map.put(new Key(), "Two");
        } catch (Exception e) {
            //expected, as no Comparator
        }
        TreeMap<ComparableKey, String> orderedMap = new TreeMap<>();
        orderedMap.put(new ComparableKey(1000000), "1000000");
        orderedMap.put(new ComparableKey(100), "100");
        orderedMap.put(new ComparableKey(500), "500");
        orderedMap.put(new ComparableKey(1), "1");
        orderedMap.put(new ComparableKey(0), "0");

        System.out.println(orderedMap);
    }
    
    static class Key {}

    static class ComparableKey implements Comparable<ComparableKey> {
        final Integer order;

        public ComparableKey(Integer order) {
            this.order = order;
        }

        @Override
        public int compareTo(ComparableKey other) {
            return order.compareTo(other.order);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", "[", "]")
                    .add("order=" + order)
                    .toString();
        }
    }
}
