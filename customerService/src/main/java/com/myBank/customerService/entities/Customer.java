package com.myBank.customerService.entities;

import com.myBank.customerService.dto.CustomerDto;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Getter @Setter @ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    @NotNull(message = "Date of birth is mandatory")
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    @NotNull(message = "Gender is mandatory")
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "national_id", nullable = false)
    private String nationalId;

    public Customer() {
    }

    public Customer(CustomerDto customerDto){
        this.id = customerDto.getId();
        this.firstName = customerDto.getFirstName();
        this.lastName = customerDto.getLastName();
        this.dateOfBirth = customerDto.getDateOfBirth();
        this.gender = customerDto.getGender();
        this.email = customerDto.getEmail();
        this.phoneNumber = customerDto.getPhoneNumber();
        this.addressLine1 = customerDto.getAddressLine1();
        this.addressLine2 = customerDto.getAddressLine2();
        this.city = customerDto.getCity();
        this.postalCode = customerDto.getPostalCode();
        this.country = customerDto.getCountry();
        this.nationalId = customerDto.getNationalId();
    }
}
