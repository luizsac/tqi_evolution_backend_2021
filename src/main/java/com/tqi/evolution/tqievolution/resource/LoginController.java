package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.LoginDTO;
import com.tqi.evolution.tqievolution.exception.PasswordIncorrectException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) throws PasswordIncorrectException, UserNotFoundException {
        return ResponseEntity.ok(userService.authenticate(loginDTO));
    }

}
