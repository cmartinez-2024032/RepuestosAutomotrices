package com.cristophermartinez.sportfinal.repository;


import com.cristophermartinez.sportfinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByFirstName(String firstName);
    boolean existsByLastName(String lastName);
}
