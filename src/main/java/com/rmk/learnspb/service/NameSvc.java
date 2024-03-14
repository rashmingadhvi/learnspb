package com.rmk.learnspb.service;

public interface NameSvc {

    String printName();
    default String printName(String name){

        return "Default - " +name;
    }


}
