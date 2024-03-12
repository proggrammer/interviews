package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Combine multiple async method calls - combine their result in Java.
 */
public class CombineMultipleAsyncResults {

    public static void invoke(int n) {
        // Simulate 50 asynchronous tasks
        List<CompletableFuture<String>> asyncTasks = createAsyncTasks(n);

        // Combine results when all tasks are completed
        CompletableFuture<String>[] arrayCF = asyncTasks.toArray(new CompletableFuture[0]);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(arrayCF);

        // Block and get the final results
        try {
            allOf.join(); // Wait for all tasks to complete
            List<String> results = asyncTasks.stream()
                    .map(CompletableFuture::join) // Get the result of each completed task
                    .collect(Collectors.toList());

            // Print or process the combined results
            results.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<CompletableFuture<String>> createAsyncTasks(int count) {
        return IntStream.range(1, count + 1)
                .mapToObj(i -> {
                    try {
                        Thread.sleep(i*1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return CompletableFuture.supplyAsync(() -> "Result from Task " + i);
                })
                .collect(Collectors.toList());
    }
}

