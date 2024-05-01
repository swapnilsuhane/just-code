package com.just.code.lld.scheduler.service;

import com.just.code.lld.scheduler.exception.ScheduleLimitExceedException;
import com.just.code.lld.scheduler.model.Task;

import java.util.LinkedList;
import java.util.Queue;

public class SchedulerServiceImpl implements SchedulerService {
    private Queue<Task> taskQueue;
    private final int CAPACITY;

    public SchedulerServiceImpl(int capacity) {
        CAPACITY = capacity;
        this.taskQueue = new LinkedList<>();
    }

    @Override
    public void scheduleTask(Task task) throws ScheduleLimitExceedException {
        if (taskQueue.size() == CAPACITY) {
            throw new ScheduleLimitExceedException("Schedule Queue capacity reached, try later");
        }
        taskQueue.add(task);
    }
}
