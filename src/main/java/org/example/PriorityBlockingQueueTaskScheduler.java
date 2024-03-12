package org.example;

import org.example.util.Task;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Build a Java task scheduler that, in case of task failure,
 * reschedules it a finite number of times while progressively increasing the waiting time for each reschedule exponentially.
 */
public class PriorityBlockingQueueTaskScheduler {
    public static void invoke( List<Task> tasksList) {
        PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<>();
        tasksList.forEach(t -> taskQueue.add(t));
        // Add initial tasks
        // Simulate task execution
        simulateTaskExecution(taskQueue);
    }

    private static void simulateTaskExecution(PriorityBlockingQueue<Task> taskQueue) {
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();

            if (task != null) {
                try {
                    long currentTime = System.currentTimeMillis();
                    if (currentTime < task.getTime()) {
                        // If the current time is before the scheduled time, sleep until the scheduled time
                        Thread.sleep(task.getTime() - currentTime);
                    }
                    // Simulate task execution
                    System.out.println("Executing task '" + task.getName() + "' at " + System.currentTimeMillis());
                    // If the execution is successful, you might want to remove the task from the queue
                    // Otherwise, reschedule the task with twice the last time and add it back to the queue
                    if (taskExecutionSuccessful()) {
                        // Remove the task or process the successful execution
                        System.out.println("Task '" + task.getName() + "' executed successfully");
                    } else {
                        // Reschedule the task and add it back to the queue
                        task.reschedule();
                        taskQueue.add(task);
                        System.out.println("Task '" + task.getName() + "' FAILED");
                        System.out.println("Task '" + task.getName() + "' rescheduled for " + task.getTime());
                    }
                } catch (Exception e) {
                    // Handle exceptions during task execution
                    System.err.println("Error executing task '" + task.getName() + "': " + e.getMessage());
                }
            }
        }
    }

    private static boolean taskExecutionSuccessful() {
        // Simulate whether the task execution is successful or not
        return Math.random() < 0.8; // 80% success rate
    }
}

