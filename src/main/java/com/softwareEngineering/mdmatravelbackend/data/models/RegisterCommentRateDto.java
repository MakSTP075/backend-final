package com.softwareEngineering.mdmatravelbackend.data.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data

public class RegisterCommentRateDto {

    private long userID;

    private long restaurantID;

    private long historicID;

    private long siteviewID;

    private String comment;

    private int rate;
}
