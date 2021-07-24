package com.smart_city.SmartCity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JobseekerController

{

    @RequestMapping(path = "/jobseeker", method = RequestMethod.GET)
    public String studentPage()
    {
        return "jobseeker";
    }
}
