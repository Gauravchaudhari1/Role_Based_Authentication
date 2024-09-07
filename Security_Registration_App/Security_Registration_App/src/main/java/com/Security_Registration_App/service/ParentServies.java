package com.Security_Registration_App.service;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Security_Registration_App.entity.Parent;
import com.Security_Registration_App.repo.ParentRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class ParentServies {

    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Parent createParent(Parent parent) {

        String password = passwordEncoder.encode(parent.getPassword());
        parent.setPassword(password);
        parent.setRole("ROLE_USER");

        return parentRepo.save(parent);

    }

    public void removeSessionMassege() {

        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
                .getSession();

        session.removeAttribute("msg");
    }

}
