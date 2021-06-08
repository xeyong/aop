package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        /*
        ParameterAop(=Aspect)에서 공통기능을 구현함으로서 서비스에서는 코드를 뺄수있게됨
        System.out.println("get method ");
        System.out.println("get method "+id);
        System.out.println("get method "+name);
        */
        return id + " " +name;
        
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        /*
        System.out.println("post method: "  + user);
         */
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
