package com.balodza;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicNonAtomic {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Value atomicValue = new AtomicValue();
        Value regularValue = new RegularValue();
        for (int i = 0; i < 50; i++) {
            final Calculator atomicCalculator = new Calculator(atomicValue);
            final Calculator regularCalculator = new Calculator(regularValue);
            executorService.submit(atomicCalculator);
            executorService.submit(regularCalculator);
        }
        Thread.sleep(10000);
        System.out.println("regular value: " + regularValue.getValue()); // random
        System.out.println("atomic value: " + atomicValue.getValue()); // 50.000
        executorService.shutdown();
    }

    static class Calculator implements Runnable {

        private final Value value;

        public Calculator(Value value) {
            this.value = value;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                value.increment();
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    interface Value {
        int getValue();

        void increment();
    }


    static class AtomicValue implements Value {

        private final AtomicInteger value = new AtomicInteger(0);

        @Override
        public int getValue() {
            return value.intValue();
        }

        @Override
        public void increment() {
            value.incrementAndGet();
        }
    }


    static class RegularValue implements Value {

        private int value = 0;

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public void increment() {
            value = value + 1;
        }
    }

}
