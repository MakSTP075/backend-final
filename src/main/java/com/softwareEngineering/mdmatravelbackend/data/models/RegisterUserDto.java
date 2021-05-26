package com.softwareEngineering.mdmatravelbackend.data.models;

import lombok.Data;

import java.util.List;

@Data
public class RegisterUserDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Boolean isAdmin;
}
