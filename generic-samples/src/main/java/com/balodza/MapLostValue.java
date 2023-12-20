package com.balodza;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Mutable key leads to elements lost.
 */
public class MapLostValue {
    public static void main(String[] args) {
        Map<MapKey, String> map = new HashMap<>();
        MapKey key1 = new MapKey(123, "key 1");
        MapKey key2 = new MapKey(256, "key 2");
        map.put(key1, "key1");
        map.put(key2, "key2");
        key1.setKey(100);
        key2.setValue("key 3");
        System.out.println("get(key1): " + map.get(key1));
        System.out.println("get(key2): " + map.get(key2));
        System.out.println("values in map: " + map.values());
    }
    
    static class MapKey {
        private int key;
        private String value;

        public MapKey(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof MapKey mapKey)) {
                return false;
            }

            return Objects.equals(value, mapKey.value);
        }
    }
}
