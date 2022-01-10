package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.dto.AuthenticatedUserDTO;
import com.tqi.evolution.tqievolution.dto.LoginDTO;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.exception.PasswordIncorrectException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.repository.UserRepository;
import com.tqi.evolution.tqievolution.security.JWTCreator;
import com.tqi.evolution.tqievolution.security.JWTObject;
import com.tqi.evolution.tqievolution.security.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private SecurityConfig securityConfig;

    @Override
    public User add(User user) throws EmailAlreadyRegisteredException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyRegisteredException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public AuthenticatedUserDTO authenticate(LoginDTO loginDTO) throws PasswordIncorrectException, UserNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(loginDTO.getUsername());

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }

        boolean passwordMatches = passwordEncoder.matches(loginDTO.getPassword(), userOptional.get().getPassword());
        if (!passwordMatches) {
            throw new PasswordIncorrectException();
        }

        JWTObject jwtObject = new JWTObject(
                userOptional.get().getEmail(),
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION),
                userOptional.get().getRoles()
        );

        String token = JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject);

        return AuthenticatedUserDTO.toDTO(userOptional.get(), token);
    }

}
