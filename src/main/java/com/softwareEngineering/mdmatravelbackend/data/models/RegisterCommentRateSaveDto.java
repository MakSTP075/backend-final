package com.softwareEngineering.mdmatravelbackend.data.models;

import com.softwareEngineering.mdmatravelbackend.data.models.User;
import com.softwareEngineering.mdmatravelbackend.data.models.Restaurant;
import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import com.softwareEngineering.mdmatravelbackend.data.models.Siteview;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Getter
@Setter

public class RegisterCommentRateSaveDto {

    private User userID;

    public RegisterCommentRateSaveDto(User userID, Restaurant restaurantID, Historic historicID, Siteview siteviewID, String comment, int rate) {
        this.userID = userID;
        this.restaurantID = restaurantID;
        this.historicID = historicID;
        this.siteviewID = siteviewID;
        this.comment = comment;
        this.rate = rate;
    }

    private Restaurant restaurantID;

    private Historic historicID;

    private Siteview siteviewID;

    private String comment;

    private int rate;
}
