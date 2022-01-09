package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.dto.AuthenticatedUserDTO;
import com.tqi.evolution.tqievolution.dto.LoginDTO;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.exception.BadCredentialsException;

import java.math.BigDecimal;

public interface UserService {

    User add(User user) throws EmailAlreadyRegisteredException;
    //User update(long id, User user) throws UserNotFoundException;
    //User updateIncome(long id, BigDecimal updatedIncome) throws UserNotFoundException;
    User authenticate(LoginDTO loginInfo) throws BadCredentialsException;

}
