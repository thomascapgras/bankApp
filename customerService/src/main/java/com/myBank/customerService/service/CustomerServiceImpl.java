package com.myBank.customerService.service;

import com.myBank.customerService.dao.CustomerDao;
import com.myBank.customerService.dto.CustomerDto;
import com.myBank.customerService.entities.Customer;
import com.myBank.customerService.exeption.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Override
    @Transactional
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto);
        customer = this.customerDao.saveCustomer(customer);
        customerDto = new CustomerDto(customer);
        return customerDto;
    }

    @Override
    public CustomerDto findCustomerById(int id) throws CustomerNotFoundException {
        Customer customer = this.customerDao.findCustomerById(id);
        CustomerDto customerDto = new CustomerDto(customer);
        return customerDto;
    }

    @Override
    public CustomerDto findCustomerByNationalId(String nationalId) throws NoResultException {
        Customer customer = this.customerDao.findCustomerByNationalId(nationalId);
        CustomerDto customerDto = new CustomerDto(customer);
        return customerDto;
    }

    @Override
    @Transactional
    public CustomerDto updateCustomer(CustomerDto customerDto) throws CustomerNotFoundException {
        Customer customer = new Customer(customerDto);
        customer = this.customerDao.updateCustomer(customer);
        customerDto = new CustomerDto(customer);
        return customerDto;
    }

    @Override
    @Transactional
    public CustomerDto deleteCustomer(CustomerDto customerDto) throws CustomerNotFoundException {
        Customer customer = new Customer(customerDto);
        customer = this.customerDao.deleteCustomer(customer);
        customerDto = new CustomerDto(customer);
        return customerDto;
    }
}
