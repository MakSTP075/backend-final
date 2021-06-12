package com.softwareEngineering.mdmatravelbackend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor


public class CommentRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private int rate;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "historic_id")
    private Historic historic;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "siteview_id")
    private Siteview siteview;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;
}
