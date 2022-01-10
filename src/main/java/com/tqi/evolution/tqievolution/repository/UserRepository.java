package com.tqi.evolution.tqievolution.repository;

import com.tqi.evolution.tqievolution.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM user u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

}