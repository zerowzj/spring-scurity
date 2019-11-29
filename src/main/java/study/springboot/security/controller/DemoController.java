package study.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/demo1")
    public String demo(){

        return "demo";
    }

    @RequestMapping("/demo2")
    public String demo1(){

        return "demo";
    }
}
