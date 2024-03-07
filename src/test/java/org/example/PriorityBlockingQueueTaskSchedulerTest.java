package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriorityBlockingQueueTaskSchedulerTest {

    @Test
    void invoke() {
        List<Task> taskList = List.of(
                new Task("Task 1", System.currentTimeMillis() + 3000),
                new Task("Task 2", System.currentTimeMillis() + 6000),
                new Task("Task 3", System.currentTimeMillis() + 9000),
                new Task("Task 4", System.currentTimeMillis() + 12000),
                new Task("Task 5", System.currentTimeMillis() + 15000),
                new Task("Task 6", System.currentTimeMillis() + 18000),
                new Task("Task 7", System.currentTimeMillis() + 21000),
                new Task("Task 8", System.currentTimeMillis() + 24000),
                new Task("Task 9", System.currentTimeMillis() + 27000),
                new Task("Task 10", System.currentTimeMillis() + 30000)); // 6 seconds from now
        PriorityBlockingQueueTaskScheduler.invoke(taskList);
    }
}