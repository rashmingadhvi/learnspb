package com.rmk.learnspb.service;

import com.rmk.learnspb.util.ConcurrentWorkUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@Service
public class ConsurrentSvcImpl implements ConcurrentSvc{

    @Override

    public void doWork() {



        try(ExecutorService executorService = Executors.newFixedThreadPool(2)){
            executorService.submit(()->
                    {
                        log.info("Starting a heavy work");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            log.error(e.getMessage(), e);
                            Thread.currentThread().interrupt();
                        }
                        log.info("Executing the work");
                    }

            );

            log.info("In the main thread");

            executorService.submit(new ConcurrentWorkUtil());


        /*try {
            Thread.currentThread().join(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }


        try(ExecutorService svc1 = Executors.newScheduledThreadPool(5)){

            Runnable runnable = () -> log.info(" {} is Running a command!", Thread.currentThread().getName());
            svc1.execute(runnable);

        }catch (Exception e){
            log.error(e.getMessage(), e);
        }finally {
            log.info("Finally ends");
        }

    }

    @Override
    public void doTask() {

        log.info("{} is doing a task", Thread.currentThread().getName());

        try(ScheduledExecutorService svc1 = Executors.newScheduledThreadPool(5)){



            ScheduledFuture<List<String>> future = svc1.schedule(
                    ()->{
                        log.info("T = {}", Thread.currentThread().getName());
                        return this.readFile();
                        }
                    , 30
                    , TimeUnit.SECONDS
            );
            List<String> lines  = future.get();



            for(int i=0;i<lines.size();++i){
                log.debug(lines.get(i));
            }


        }catch (Exception e){
            log.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
        }finally {
            log.info("Finally ends");
        }


    }

    private List<String> readFile(){
        try {
            Thread.sleep(1000);
            return Files.readAllLines(Paths.get(this.getClass().getResource("/sample.txt").toURI()), Charset.defaultCharset());
        } catch (IOException | URISyntaxException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

}
