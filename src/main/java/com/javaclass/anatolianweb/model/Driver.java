package com.javaclass.anatolianweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Driver extends User implements Serializable {

    private LocalDate medCertificateDate;
    private String medCertificateNumber;
    private String driverLicense;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> myComments;

    @JsonIgnore
    @OneToOne
    private Driver driver;


    public Driver(String login, String password, String name, String surname, LocalDate birthDate, String phoneNum, LocalDate medCertificateDate, String medCertificateNumber, String driverLicense) {
        super(login, password, name, surname, birthDate, phoneNum); //, deleted user_image
        this.medCertificateDate = medCertificateDate;
        this.medCertificateNumber = medCertificateNumber;
        this.driverLicense = driverLicense;
    }

   // Old one

//    public Driver(String login, String password, String name, String surname, LocalDate birthDate, String phoneNum, byte[] user_image, LocalDate medCertificateDate, String medCertificateNumber, String driverLicense) {
//        super(login, password, name, surname, birthDate, phoneNum, user_image);
//        this.medCertificateDate = medCertificateDate;
//        this.medCertificateNumber = medCertificateNumber;
//        this.driverLicense = driverLicense;
//    }



    @Override
    public String toString() {
        return "("+id+")  "+ getName() ;
    }

}
