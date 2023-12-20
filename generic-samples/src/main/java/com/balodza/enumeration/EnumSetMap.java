package com.balodza.enumeration;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumSetMap {
    public static void main(String[] args) {
        EnumSet<TestEnum> enumSet = EnumSet.of(TestEnum.ONE, TestEnum.TWO);
        enumSet.add(TestEnum.THREE);
        enumSet.remove(TestEnum.ONE);
        enumSet.remove(null);
        //enumSet.add(null); Exception
        System.out.println(enumSet);
        
        
        EnumMap<TestEnum, String> enumMap = new EnumMap<>(TestEnum.class);
        enumMap.put(TestEnum.ONE, "Value of ONE");
        enumMap.put(TestEnum.TWO, null);
        enumMap.remove(null);
        //enumMap.put(null, null); Exception
        System.out.println(enumMap);
    }
}
