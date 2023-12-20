package com.balodza;

import java.util.ArrayList;
import java.util.List;

public class WildcardList {
    public static void main(String[] args) {
        List<? extends A> list = new ArrayList<>();
        //list.add(new A()); uncomment to see problem
        List<A> casted = (List<A>) list;
        casted.add(new A());
        casted.add(new B());
        casted.add(new C());
        f(casted);
        f(list);
    }
    
    public static void f(List<? extends A> list) {
        //list.add(new A()); uncomment to see problem
    }
    
    static class A {}
    
    static class B extends A {}

    static class C extends B {}
    
}
