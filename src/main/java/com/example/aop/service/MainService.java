package com.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    public String method(){
        return "Method ";
    }

    public void voidMethod(){

    }


    public void voidMethodWithParam(String s){
    }

    public String methodWithParam(String s){
        return s;
    }

    public void methodException() throws Exception {
        throw new Exception("Exception ops...");
    }
}
