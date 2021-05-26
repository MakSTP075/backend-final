package com.softwareEngineering.mdmatravelbackend.services;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterUserDto;
import com.softwareEngineering.mdmatravelbackend.data.models.User;
import com.softwareEngineering.mdmatravelbackend.repositories.UserRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional()
    public User registerUser(RegisterUserDto userRegister) {
        log.debug("Request to REGISTER employee : {}", userRegister);
        User user = userMapper.toEntity(userRegister);
        user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        user = userRepository.save(user);

        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow();
    }
}
