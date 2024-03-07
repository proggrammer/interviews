package org.example.util;

public class Task implements Comparable<Task> {
    private String name;
    private long time;
    private int rescheduledTimes =0;

    public Task(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public void reschedule() {
        // Reschedule with twice the last time
        time = System.currentTimeMillis() + (2^++rescheduledTimes);
    }

    @Override
    public int compareTo(Task other) {
        return Long.compare(this.time, other.time);
    }
}
