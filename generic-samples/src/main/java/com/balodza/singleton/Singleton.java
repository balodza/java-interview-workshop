package com.balodza.singleton;

import java.io.Serializable;

public final class Singleton implements Serializable {

    private static Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
