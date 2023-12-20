package com.balodza.enumeration;

public enum TestEnum {
    ONE("one", 1),
    TWO("two", 2),
    THREE("three", 3);

    private final String value;
    private final int count;

    TestEnum(String value, int count) {
        this.value = value;
        this.count = count;
    }

    public static void main(String[] args) {
        System.out.println("Enum main");
    }
}
