package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.dto.AuthenticatedUserDTO;
import com.tqi.evolution.tqievolution.dto.LoginDTO;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.exception.PasswordIncorrectException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;

public interface UserService {

    User add(User user) throws EmailAlreadyRegisteredException;
    AuthenticatedUserDTO authenticate(LoginDTO loginInfo) throws PasswordIncorrectException, UserNotFoundException;

}
