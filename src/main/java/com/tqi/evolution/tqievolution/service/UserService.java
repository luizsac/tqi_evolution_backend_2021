package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserService {

    User add(User user) throws EmailAlreadyRegisteredException;
    User findById(long id);
    Optional<User> findByEmail(String email);
    //User update(long id, User user) throws UserNotFoundException;
    User updateIncome(long id, BigDecimal updatedIncome) throws UserNotFoundException;

}
