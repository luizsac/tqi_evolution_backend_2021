package com.tqi.evolution.tqievolution.resource;

import com.tqi.evolution.tqievolution.dto.CreatedUserDTO;
import com.tqi.evolution.tqievolution.dto.NewUserDTO;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<CreatedUserDTO> createAccount(@RequestBody NewUserDTO newUserDTO)
                                                                            throws EmailAlreadyRegisteredException {
        var createdUserDTO = CreatedUserDTO.toDto(userService.add(newUserDTO.toUser()));
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

}
