package com.balodza;

import java.util.ArrayList;
import java.util.List;

public class GenericRuntimeErasure {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        
        addInteger(list);
        addObject(list);

        System.out.println(list);
        
        // here become troubles
        for (String string : list) {
            System.out.println(list);
        }
    }

    private static void addObject(List list) {
        list.add(new IllegalAccessError());
    }

    private static void addInteger(List strings) {
        strings.add(Integer.valueOf(5));
    }
}
