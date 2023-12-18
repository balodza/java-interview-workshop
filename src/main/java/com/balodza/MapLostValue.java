package com.balodza;

import java.util.HashMap;
import java.util.Map;

/**
 * Mutable key leads to elements lost.
 */
public class MapLostValue {
    public static void main(String[] args) {
        Map<MapKey, String> map = new HashMap<>();
        MapKey key1 = new MapKey(123);
        MapKey key2 = new MapKey(256);
        map.put(key1, "key1");
        map.put(key2, "key2");
        key1.setKey(100);
        System.out.println("get(key1): " + map.get(key1));
        System.out.println("get(key2): " + map.get(key2));
        System.out.println("values in map: " + map.values());
    }
    
    static class MapKey {
        private int key;

        public MapKey(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int hashCode() {
            return key;
        }
    }
}
