package com.Security_Registration_App.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Security_Registration_App.entity.Parent;
import com.Security_Registration_App.repo.ParentRepo;
import com.Security_Registration_App.service.ParentServies;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private ParentServies parentServies;

    @Autowired
    private ParentRepo parentRepo;

    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            Parent parent = parentRepo.findByEmail(email);
            m.addAttribute("parent", parent);
        }

    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    // @GetMapping("/parent/profile")
    // public String profile(Principal p, Model m) {
    // String email = p.getName();
    // Parent parent = parentRepo.findByEmail(email);
    // m.addAttribute("parent", parent);
    // return "profile";
    // }

    @GetMapping("/parent/home")
    public String home() {
        return "home";
    }

    @PostMapping("/saveParent")
    public String saveParent(@ModelAttribute Parent parent, HttpSession session, Model m) {

        // System.out.println(user);

        Parent p = parentServies.createParent(parent);

        if (p != null) {
            // System.out.println("save sucess");
            session.setAttribute("msg", "Register successfully");

        } else {
            // System.out.println("error in server");
            session.setAttribute("msg", "Something wrong server");
        }
        return "redirect:/register";
    }

}