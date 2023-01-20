package me.xiaoz.concurrent;

import java.util.Collections;
import java.util.concurrent.*;

public class SquareCalculator {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) throws ExecutionException, InterruptedException {
        Future<Integer> future = executor.submit(() -> input);
        Integer integer = future.get();
        return future;
    }
}
