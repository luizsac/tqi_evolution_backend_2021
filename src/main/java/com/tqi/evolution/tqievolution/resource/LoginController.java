package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.AuthenticadedUserDTO;
import com.tqi.evolution.tqievolution.dto.LoginDTO;
import com.tqi.evolution.tqievolution.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginDTO loginInfo) {
        return null;
    }

}
