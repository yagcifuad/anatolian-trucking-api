package com.javaclass.anatolianweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNum;
    //private byte[] user_image;

    private String userUID;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> myComments;
    public User(String login, String password, String name, String surname, LocalDate birthDate, String phoneNum) {//deleted this byte[] user_image
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNum = phoneNum;
        //this.user_image = user_image;
    }

}
