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
public class AdminController {


    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<UserInfo> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("userInfo", new UserInfo());
        return "admin";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.POST)
    public RedirectView createUser(RedirectAttributes redirectAttributes, @ModelAttribute UserInfo userInfo) {
        userService.createUser(userInfo);
        String message = "Created user <b>" + userInfo.getFirstName() + " " + userInfo.getLastName() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/admin", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    @RequestMapping(path = "/admin/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Integer id) {
        UserInfo userInfo = userService.getUser(id);
        model.addAttribute("userInfo", userInfo);
        return "edit";
    }

    @RequestMapping(path = "/admin/{id}", method = RequestMethod.POST)
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id, @ModelAttribute UserInfo userInfo) {
        userService.updateUser(id, userInfo);
        String message = (userInfo.isActive() ? "Updated " : "Deleted ") + " user <b>" + userInfo.getFirstName() + " " + userInfo.getLastName() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/admin", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

}
