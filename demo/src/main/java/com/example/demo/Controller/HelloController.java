package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @GetMapping("/hello")
    public String helloPage(@RequestParam(required = false) String username){
        return "Hello world! " + username;
    }

    @GetMapping("/hello/{username}")
    public String helloPagePathVariable(@PathVariable("username") String user){
        return "Hello world! " + user;
    }
}
