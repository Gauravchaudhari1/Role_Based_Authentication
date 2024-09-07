package com.Security_Registration_App.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Security_Registration_App.entity.Parent;
import com.Security_Registration_App.repo.ParentRepo;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

    @GetMapping("/profile")
    public String profile() {
        return "admin_profile";
    }
}