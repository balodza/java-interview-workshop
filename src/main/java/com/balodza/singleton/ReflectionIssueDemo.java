package com.balodza.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionIssueDemo {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = null;
        for (Constructor<?> constructor : singleton.getClass().getDeclaredConstructors()) {
            constructor.setAccessible(true);
            singleton2 = (Singleton) constructor.newInstance();
        }
        System.out.println("singleton1 hashCode: "+ singleton.hashCode());
        System.out.println("singleton2 hashCode: "+ singleton2.hashCode());
        System.out.println("singleton1 == singleton2:" + (singleton == singleton2));
    }
}
