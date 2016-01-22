package com.cxjhihihi.springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.cxjhihihi.springmvc.service.UserService;

/**
 * @author hzcaixinjia
 */
@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    UserService userService;

    @RequestMapping("/user/show.m")
    public void show(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        JSONObject jv = new JSONObject();
        jv.put("username", userService.getUsername());
        jv.put("password", userService.getPassword());
        response.getWriter().write(jv.toString());
    }
}
