package com.smart_city.SmartCity;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmartCityController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="na", required=false, defaultValue="World") String name, Model model)
    {
        model.addAttribute("name", name);
        Object world=" good morning";
        model.addAttribute("World", world );
        return "greeting";
    }

}


