package com.lhp.controller;

import com.lhp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname AdminTestController
 * @Description TODO
 * @Date 2019/11/16 20:32
 * @Created by
 */
@Controller
@RequestMapping("/admin")
public class AdminTestController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @RequestMapping("/home")
    @ResponseBody
        public String productInfo(){
        String str = userServiceImpl.updateUserName( 1);

        return str;
    }
}