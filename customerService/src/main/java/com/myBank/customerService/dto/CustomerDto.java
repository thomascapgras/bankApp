package com.myBank.customerService.dto;
import com.myBank.customerService.dao.CustomerDao;
import com.myBank.customerService.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter @Setter @ToString
public class CustomerDto {

    private int id;
    @NotNull(message = "Firstname is mandatory")
    private String firstName;
    @NotNull(message = "Lastname is mandatory")
    private String lastName;
    @NotNull(message = "Date of birth is mandatory")
    private LocalDate dateOfBirth;
    @NotNull(message = "Gender is mandatory")
    private String gender;
    @NotNull(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Phone number is mandatory")
    private String phoneNumber;
    private String addressLine1;

    private String addressLine2;
    @NotNull(message = "City is mandatory")
    private String city;
    @NotNull(message = "Postal code is mandatory")
    private String postalCode;
    @NotNull(message = "Country is mandatory")
    private String country;
    @NotNull(message = "National ID is mandatory")
    private String nationalId;

    public CustomerDto(){

    }

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.dateOfBirth = customer.getDateOfBirth();
        this.gender = customer.getGender();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
        this.addressLine1 = customer.getAddressLine1();
        this.addressLine2 = customer.getAddressLine2();
        this.city = customer.getCity();
        this.postalCode = customer.getPostalCode();
        this.country = customer.getCountry();
        this.nationalId = customer.getNationalId();
    }

}
