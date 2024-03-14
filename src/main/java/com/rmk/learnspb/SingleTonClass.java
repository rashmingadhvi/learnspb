package com.rmk.learnspb;

import java.util.Objects;

public class SingleTonClass {


    private static SingleTonClass obj;
    private SingleTonClass(){

    }

    public static synchronized SingleTonClass getInstance(){
        if(Objects.isNull(obj)){
            obj = new SingleTonClass();

        }

        return obj;
    }

    public String printInfo() {
        return "";
    }

}
