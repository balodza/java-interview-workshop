package com.balodza.initialization;

public class InitializationTest {
    public static void main(String[] args) {
        InitializationOrder.staticMethod();
        final InitializationOrder initializationOrder = new InitializationOrder("test");
    }
}
