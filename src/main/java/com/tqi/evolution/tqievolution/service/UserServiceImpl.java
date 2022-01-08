package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.dto.AuthenticatedUserDTO;
import com.tqi.evolution.tqievolution.dto.LoginDTO;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.exception.BadCredentialsException;
import com.tqi.evolution.tqievolution.repository.UserRepository;
import com.tqi.evolution.tqievolution.util.Encrypter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User add(User user) throws EmailAlreadyRegisteredException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyRegisteredException();
        }

        user.setPassword(Encrypter.encrypt(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User authenticate(LoginDTO loginDTO) throws BadCredentialsException {
        Optional<User> userOptional = userRepository.findByEmail(loginDTO.getEmail());

        String encryptedPassword = Encrypter.encrypt(loginDTO.getPassword());
        if (userOptional.isEmpty() || !userOptional.get().getPassword().equals(encryptedPassword)) {
            throw new BadCredentialsException();
        }

        return userOptional.get();
    }

    /*@Override
    public User updateIncome(long id, BigDecimal updatedIncome) throws UserNotFoundException {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        user.setIncome(updatedIncome);

        return userRepository.save(user);
    }*/

    /*public User update(long id, User user) throws UserNotFoundException {
        User recordedUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setPassword(Encrypter.encrypt(user.getPassword()));
        recordedUser.updateFields(user);
        return userRepository.save(recordedUser);
    }*/

}
