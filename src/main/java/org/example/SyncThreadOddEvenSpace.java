package org.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Develop a Java program with three threads: the first thread prints odd integers, the second thread prints even
 * integers, and the third thread prints delimiters. Ensure synchronization so that the program prints integers from 1
 * to n with appropriate delimiters.
 */
public class SyncThreadOddEvenSpace {

    private static final Object lock = new Object();
    private static int counter = 1;
    private static final char delimiter = ',';
    private static final int MAX_COUNT = 100;

    private static final String ODD = "odd", EVEN = "even", DEL = "del";

    private static String TURN = ODD;

    public static void print() {
        System.out.println("Start");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List.of(ODD, EVEN, DEL).forEach(name -> executorService.submit(() -> printForEachThread(name)));

        executorService.shutdown();
        awaitTermination(executorService);

        System.out.println("End");
    }

    private static void awaitTermination(ExecutorService executorService) {
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printForEachThread(String threadName) {
        while (counter <= MAX_COUNT) {
            synchronized (lock) {
                if (!threadName.equals(TURN)) {
                    waitForTurn();
                } else if (TURN.equals(DEL)) {
                    printDelimiter();
                } else {
                    printNumber();
                }
            }
        }
    }

    private static void waitForTurn() {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printDelimiter() {
        System.out.print(delimiter);
        System.out.flush();
        TURN = (counter % 2 == 0) ? EVEN : ODD;
        lock.notifyAll();
    }

    private static void printNumber() {
        System.out.print(counter++);
        System.out.flush();
        TURN = DEL;
        lock.notifyAll();
    }
}
