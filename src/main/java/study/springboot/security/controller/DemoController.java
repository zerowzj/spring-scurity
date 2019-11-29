package study.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/a-1")
    public String demo(){

        return "demo";
    }

    @RequestMapping("/a-2")
    public String demo1(){

        return "demo";
    }
}
