package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.AuthenticatedUserDTO;
import com.tqi.evolution.tqievolution.dto.LoginDTO;
import com.tqi.evolution.tqievolution.exception.PasswordIncorrectException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<AuthenticatedUserDTO> login(@RequestBody LoginDTO loginDTO)
            throws PasswordIncorrectException, UserNotFoundException {
        return new ResponseEntity<>(userService.authenticate(loginDTO), HttpStatus.OK);
    }

}
