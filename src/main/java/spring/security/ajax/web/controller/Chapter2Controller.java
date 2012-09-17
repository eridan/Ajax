package spring.security.ajax.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Chapter2Controller {

    @RequestMapping("/chapter2.do")
    public String registration() {
        return "registration";
    }
}
