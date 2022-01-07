package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.EmailAlreadyRegisteredException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.repository.UserRepository;
import com.tqi.evolution.tqievolution.util.Encrypter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
    public User findById(long id) {
        return null;
    }

    @Override
    public User updateIncome(long id, BigDecimal updatedIncome) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setIncome(updatedIncome);
        return userRepository.save(user);
    }





    /*public User update(long id, User user) throws UserNotFoundException {
        User recordedUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setPassword(Encrypter.encrypt(user.getPassword()));
        recordedUser.updateFields(user);
        return userRepository.save(recordedUser);
    }*/

}
