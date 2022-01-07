package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.AuthenticadedUserDTO;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createAccount(@RequestBody User user) throws EmailAlreadyRegisteredException {
        System.out.println(user);
        return new ResponseEntity<User>(userService.add(user), HttpStatus.CREATED);
    }

}
