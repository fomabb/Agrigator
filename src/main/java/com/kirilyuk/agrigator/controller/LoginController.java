package com.kirilyuk.agrigator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public ModelAndView getApplications(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
