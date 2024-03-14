package com.rmk.learnspb;


import com.rmk.learnspb.service.NameSvc;
import com.rmk.learnspb.service.NameSvcImpl;
import com.rmk.learnspb.service.NameSvcImpl2;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


interface AnnonymousClass1 {

    void printName();
}

@Data
@Slf4j
public class PlainJavaClass {




    String name;
    int age;
    static String country;



    @Override
    public String toString(){
        log.debug("name = " + this.name);
        log.debug("age = " + this.age);
        return StringUtils.EMPTY;
    }

    public static void main(String[] args) {
        PlainJavaClass obj1 = new PlainJavaClass();
        log.info("obj1 = " + obj1);
        obj1.setName("New name");


        NameSvc nameSvc = new NameSvcImpl();
        NameSvc nameSvc2 = new NameSvcImpl2();
        log.info(nameSvc.printName());
        log.info(nameSvc2.printName());
        log.info(nameSvc.printName("Gadhvi"));

        /* Anonymous Class*/

        AnnonymousClass1 class1 = new AnnonymousClass1() {
            @Override
            public void printName() {
                log.info("{} - Print Name", this.getClass().getName());
            }
        };

        class1.printName();


        SingleTonClass single = SingleTonClass.getInstance();
        log.info(single.toString());

        SingleTonClass single2 = SingleTonClass.getInstance();
        log.info(single2.toString());



    }



}
