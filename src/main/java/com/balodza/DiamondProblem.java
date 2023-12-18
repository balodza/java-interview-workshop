package com.balodza;

public class DiamondProblem {
    public static void main(String[] args) {
        System.out.println(DiamondProblem.f(1));
        System.out.println(DiamondProblem.f(Integer.parseInt("10")));
        System.out.println(DiamondProblem.f((Integer)1));
        System.out.println(DiamondProblem.f(Integer.valueOf(10)));
    }
    
    static Integer f(int i) {
        return 1;
    }
    
    static int f(Integer i) {
        return 2;
    }
    
}
