package com.rmk.learnspb.controller;

import com.rmk.learnspb.model.StudentModel;
import com.rmk.learnspb.service.NameSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    @PostMapping(value = "/savestudent")
    public ResponseEntity<StudentModel> saveStudentData(@RequestBody StudentModel model){
        log.info(" ID: {}, Name: {} ", model.getStudentId(), model.getFName()+model.getLName());
        if(model.getStudentId()<10){
            return ResponseEntity.badRequest().body(null);
        }
        //return new ResponseEntity<>(model, HttpStatusCode.valueOf(200));
        return ResponseEntity.ok(model);
    }

    @GetMapping(value = "/getfile", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<byte[]> getFile() throws IOException {

        return ResponseEntity.ok(
                Files.readAllBytes(Path.of("/Users/rashmingadhavi/Projects/Learn-JAVA-SPB/learnspb/spb.log"))
        );
    }
}
