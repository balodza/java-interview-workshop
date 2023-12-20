package com.balodza;

public class CloneableTransientDemo {
    
    static class Data implements Cloneable {
        String name;
        String surname;
        transient int age;
        
        public Data(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        final Data data = new Data("bob", "st");
        Data data2 = (Data) data.clone();
        
        System.out.println("name: " + data2.name);
        System.out.println("surname: " + data2.surname);
        System.out.println("age: " + data2.age);
    }
    
    
}
