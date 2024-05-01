package com.just.code.lld.scheduler;

import com.just.code.lld.scheduler.service.SchedulerService;
import com.just.code.lld.scheduler.service.SchedulerServiceImpl;

public class SchedulerMain {

    public static void main(String[] args) {
        SchedulerService schedulerService = new SchedulerServiceImpl(10);


    }
}
