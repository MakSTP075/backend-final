package com.softwareEngineering.mdmatravelbackend.data.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data

public class RegisterHistoricDto {

    private String historicName;

    private String details;

    // private data type za img
}
