package com.myBank.customerService.controller;

import com.myBank.customerService.dto.CustomerDto;
import com.myBank.customerService.exeption.CustomerNotFoundException;
import com.myBank.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomerById/{id}")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        try {
            CustomerDto customerDto = this.customerService.findCustomerById(id);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>("Customer not found for id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCustomerByNationalId/{nationalId}")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?> getCustomerByNationalId(@PathVariable String nationalId) {
        try {
            CustomerDto customerDto = customerService.findCustomerByNationalId(nationalId);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found for nationalId : " + nationalId);
        }

    }

    @PostMapping("/saveCustomer")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
            customerDto = this.customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @PostMapping("/updateCustomer")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto) {
        try {
            customerDto = this.customerService.updateCustomer(customerDto);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>("Customer not found for update with id: " + customerDto.getId(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?> deleteCustomer(@RequestBody CustomerDto customerDto) {
        try {
            this.customerService.deleteCustomer(customerDto);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>("Customer not found for delete with id: " + customerDto.getId(), HttpStatus.NOT_FOUND);
        }
    }
}
