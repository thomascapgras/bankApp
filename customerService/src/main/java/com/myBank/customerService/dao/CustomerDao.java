package com.myBank.customerService.dao;

import com.myBank.customerService.entities.Customer;
import com.myBank.customerService.exeption.CustomerNotFoundException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public interface CustomerDao {
    public Customer saveCustomer(Customer customer) ;
    public Customer findCustomerById (int id) throws CustomerNotFoundException;
    public Customer findCustomerByNationalId (String nationalId) throws NoResultException;
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
    public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;


}
