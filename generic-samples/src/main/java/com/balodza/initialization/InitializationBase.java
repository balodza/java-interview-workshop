package com.balodza.initialization;

public class InitializationBase {
    {
        System.out.println("InitializationBase {} block");
    }

    static {
        System.out.println("InitializationBase static {} block");
    }

    public InitializationBase() {
        System.out.println("InitializationBase constructor()");
    }
}
