package study.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

//    @RequestMapping("/")
//    public String idnex(){
//
//        return "login";
//    }

    @RequestMapping("/demo")
    public String demo(){

        return "demo";
    }
}
