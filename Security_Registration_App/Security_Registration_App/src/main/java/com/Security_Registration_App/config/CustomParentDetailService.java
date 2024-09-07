package com.Security_Registration_App.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Security_Registration_App.entity.Parent;
import com.Security_Registration_App.repo.ParentRepo;

@Component
public class CustomParentDetailService implements UserDetailsService {

    @Autowired
    private ParentRepo parentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Parent parent = parentRepo.findByEmail(username);
        if (parent == null) {

            throw new UsernameNotFoundException("parent not found");

        } else {

            return new CustomParent(parent);
        }

    }

}
