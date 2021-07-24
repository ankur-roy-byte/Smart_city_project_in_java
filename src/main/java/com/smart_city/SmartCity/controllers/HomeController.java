package com.smart_city.SmartCity.controllers;

import com.smart_city.SmartCity.domain.entities.UserInfo;
import com.smart_city.SmartCity.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {




    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage() {
        return "homePage";
    }



}