package com.softwareEngineering.mdmatravelbackend.controllers;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterUserDto;
import com.softwareEngineering.mdmatravelbackend.data.models.User;
import com.softwareEngineering.mdmatravelbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public User register(@RequestBody RegisterUserDto userRegisterDto) {
        return userService.registerUser(userRegisterDto);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }
}
