package com.Security_Registration_App.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Security_Registration_App.entity.Parent;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Integer> {

    public Parent findByEmail(String email);
}
