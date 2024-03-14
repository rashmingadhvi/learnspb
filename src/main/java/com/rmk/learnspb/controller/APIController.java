package com.rmk.learnspb.controller;

import com.rmk.learnspb.service.NameSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class APIController {

    @Autowired
     NameSvc NameSvcImpl2;


@Autowired
    @Qualifier(value = "one")
    NameSvc nameSvc1;

    @GetMapping("/info")
    public ResponseEntity<String> getInfo(){
        return ResponseEntity.ok("How are you Krishiv!");
    }

    @GetMapping("/namesvc/{id}")
    public ResponseEntity<String> getNameService(@PathVariable("id") String serviceId){
        String msg;
        if(serviceId.equalsIgnoreCase("1")){
            msg = nameSvc1.printName();
        }else if(serviceId.equalsIgnoreCase("2")){
            msg = NameSvcImpl2.printName();
        }else{
            msg = "Wrong service ID";
        }

        return ResponseEntity.ok(msg);
    }
}
