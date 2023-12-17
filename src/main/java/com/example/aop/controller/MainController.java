package com.example.aop.controller;

import com.example.aop.model.entity.User;
import com.example.aop.repository.UserRepository;
import com.example.aop.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final MainService mainService;

    @Autowired
    private final UserRepository userRepository;

    @GetMapping("/get")
    public User method(UUID id){
        return userRepository.getReferenceById(id);
    }

    @DeleteMapping("/get")
    public void voidMethod(UUID id){
        userRepository.deleteById(id);
    }

    @PutMapping("/check/get")
    public String voidMethodWithParam(){
        return "check success!";
    }

    @PostMapping("/get")
    public String methodWithParam(@RequestParam String s){
        return mainService.methodWithParam(s);
    }

    @PostMapping("/getEx")
    public void methodException(){
        try {
            mainService.methodException();
        } catch (Exception ignored) {}
    }



}
