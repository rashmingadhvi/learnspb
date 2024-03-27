package com.rmk.learnspb.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.RunnableFuture;

@Slf4j

public class ConcurrentWorkUtil implements Runnable {

    @Override
    public void run(){


            for(int i=0;i<10;++i){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("Thread - ConcurrentWorkUtil");
            }




    }
}
