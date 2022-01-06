package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.AuthenticadedUserDTO;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createAccount(@RequestParam User user) throws EmailAlreadyRegisteredException {
        return new ResponseEntity<User>(userService.add(user), HttpStatus.CREATED);
    }

}
