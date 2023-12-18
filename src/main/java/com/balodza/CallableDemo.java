package com.balodza;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<String> submit = executorService.submit(new CallableService());
        final String result = submit.get();
        long diff = System.currentTimeMillis() - start;
        System.out.println(result);
        System.out.println("Time taken: " + diff + " ms.");
        executorService.shutdown();
    }
    
    static class CallableService implements Callable<String> {

        public String call() throws Exception {
            Thread.sleep(1000 + new Random(System.currentTimeMillis()).nextInt(2000));
            return "RESULT";
        }
    }
}
