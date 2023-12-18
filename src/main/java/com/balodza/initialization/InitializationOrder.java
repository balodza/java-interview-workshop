package com.balodza.initialization;

public class InitializationOrder extends InitializationBase {
    {
        System.out.println("InitializationOrder {} block");
    }
    
    static {
        System.out.println("InitializationOrder static {} block");
    }
    
    public InitializationOrder() {
        //super()
        System.out.println("Initialization constructor()");
    }
    
    public InitializationOrder(String str) {
        System.out.println("Initialization constructor(String str)");
    }
    
    public static void staticMethod() {
        System.out.println("static method called");
    } 
}
