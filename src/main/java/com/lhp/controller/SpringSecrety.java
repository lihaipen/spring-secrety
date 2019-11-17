package com.lhp.controller;
import	java.util.ResourceBundle.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname SpringSecrety
 * @Description TODO
 * @Date 2019/11/16 19:41
 * @Created by
 */
@Controller
public class SpringSecrety {
    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring security!";
    }
}
