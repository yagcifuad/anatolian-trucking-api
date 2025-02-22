package com.javaclass.anatolianweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager extends User implements Serializable {

    private String email;
    private LocalDate employmentDate;
    private boolean isAdmin;

//    @ManyToMany
//    private List<Destination> myManagedDestinations;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> myComments;

    public Manager(String login, String password, String name, String surname, LocalDate birthDate, String phoneNum, String email, LocalDate employmentDate, boolean isAdmin) {
        super(login, password, name, surname, birthDate, phoneNum);
        this.email = email;
        this.employmentDate = employmentDate;
        this.isAdmin = isAdmin;
    }
    //Old with photo
    // public Manager(String login, String password, String name, String surname, LocalDate birthDate, String phoneNum, byte[] user_image, String email, LocalDate employmentDate, boolean isAdmin) {
    //        super(login, password, name, surname, birthDate, phoneNum, user_image);
    //        this.email = email;
    //        this.employmentDate = employmentDate;
    //        this.isAdmin = isAdmin;
    //    }



    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "("+id+")  "+ this.getName() ;
    }




    //    public Manager(String login, String password, String name, String surname, LocalDate birthDate, String phoneNum, String userUID, String email, LocalDate employmentDate, boolean isAdmin) {
//        super(login, password, name, surname, birthDate, phoneNum, userUID);
//        this.email = email;
//        this.employmentDate = employmentDate;
//        this.isAdmin = isAdmin;
//
//    }
//
//    public Manager(String login, String password, String name, String surname, LocalDate birthDate, String phoneNum, String userUID, String email) {
//        super(login, password, name, surname, birthDate, phoneNum, userUID);
//        this.email = email;
//    }





}
