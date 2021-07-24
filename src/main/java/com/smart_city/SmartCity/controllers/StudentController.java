package com.smart_city.SmartCity.controllers;

import com.smart_city.SmartCity.domain.entities.StudentInfo;
import com.smart_city.SmartCity.services.StudentService;
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
public class StudentController {
    private final StudentService userService;

    public StudentController(StudentService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/student", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<StudentInfo> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("userInfo", new StudentInfo());
        return "student";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    public RedirectView createUser(RedirectAttributes redirectAttributes, @ModelAttribute StudentInfo userInfo) {
        userService.createUser(userInfo);
        String message = "Created user <b>" + userInfo.getFirstName() + " " + userInfo.getLastName() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/student", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Integer id) {
        StudentInfo userInfo = userService.getUser(id);
        model.addAttribute("userInfo", userInfo);
        return "edit";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.POST)
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id, @ModelAttribute StudentInfo userInfo) {
        userService.updateUser(id, userInfo);
        String message = (userInfo.isActive() ? "Updated " : "Deleted ") + " user <b>" + userInfo.getFirstName() + " " + userInfo.getLastName() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/student", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

}


