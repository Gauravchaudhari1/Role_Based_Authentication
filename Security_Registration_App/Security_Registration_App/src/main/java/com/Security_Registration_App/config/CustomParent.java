package com.Security_Registration_App.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Security_Registration_App.entity.Parent;

public class CustomParent implements UserDetails {

    @Autowired
    private Parent parent;

    public CustomParent(Parent parent) {
        this.parent = parent;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(parent.getRole());

        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {

        return parent.getPassword();
    }

    @Override
    public String getUsername() {

        return parent.getEmail();

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;

    }

}
