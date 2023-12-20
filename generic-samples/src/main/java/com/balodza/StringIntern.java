package com.balodza;

/**
 * Shows String.intern() method
 */
public class StringIntern {
    public static void main(String[] args) {
        final String string1 = new String("test");
        final String string2 = new String("test");
        System.out.println("string1 == string2: " + (string1 == string2));
        
        final String intern1 = string1.intern();
        final String intern2 = string2.intern();
        System.out.println("intern1 == intern2: " + (intern1  == intern2));
    }
}
