package com.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Consumer {

    @Autowired
    private ApplicationContext applicationContext;

    public void start(int numberOfConsumers) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfConsumers);
        for (int i=0; i< numberOfConsumers; i++) {
            Worker worker = applicationContext.getBean(Worker.class);
            executorService.submit(() -> worker.run());
        }
    }

}