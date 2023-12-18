package com.balodza;

public class Enum {
    public static void main(String[] args) {
        for (TestEnum value : TestEnum.values()) {
            System.out.println(value);
        }
    }
    
    enum TestEnum {
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3);

        private String value;
        private int count;

        TestEnum(String value, int count) {
            this.value = value;
            this.count = count;
        }

        public static void main(String[] args) {
            System.out.println("Enum main");
        }
    }
}
