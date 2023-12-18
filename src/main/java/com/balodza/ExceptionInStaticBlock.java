package com.balodza;

public class ExceptionInStaticBlock {
    static {
        int x = 1 / 0;
    }

    public static void main(String[] args) {
        System.out.println("App Run");
    }
}
