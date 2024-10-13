package com.myBank.customerService.service;

import com.myBank.customerService.dto.CustomerDto;
import com.myBank.customerService.exeption.CustomerNotFoundException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public interface CustomerService {
    public CustomerDto saveCustomer(CustomerDto customerDto) ;
    public CustomerDto findCustomerById (int id) throws CustomerNotFoundException;
    public CustomerDto findCustomerByNationalId (String nationalId) throws NoResultException;
    public CustomerDto updateCustomer(CustomerDto customerDto) throws CustomerNotFoundException;
    public CustomerDto deleteCustomer(CustomerDto customerDto) throws CustomerNotFoundException;
}
