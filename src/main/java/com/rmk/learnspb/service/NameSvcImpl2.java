package com.rmk.learnspb.service;

import org.springframework.stereotype.Service;

@Service
public class NameSvcImpl2 implements NameSvc {


    @Override
    public String printName() {
        return "This is NameSvcImpl-2";
    }
}
