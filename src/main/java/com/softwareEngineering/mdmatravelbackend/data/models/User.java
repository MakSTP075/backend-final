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
@Table(name = "a_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Boolean isAdmin;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    private List<CommentRate> user = new ArrayList<>();
}
