package com.icore.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot")
public class Controller {

    @RequestMapping("/test")
    public String test(){
        return "BOOT-T E S T";
    }

}
