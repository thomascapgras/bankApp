package com.myBank.customerService.dao;

import com.myBank.customerService.entities.Customer;
import com.myBank.customerService.exeption.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

@Repository
public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    private EntityManager em;
    @Override
    public Customer saveCustomer(Customer customer){
        this.em.persist(customer);
        return customer;
    }

    @Override
    public Customer findCustomerById(int id) throws CustomerNotFoundException {
        Customer customer = this.em.find(Customer.class,id);
        if (customer==null){
            throw new CustomerNotFoundException("customer not found for id : " + id);
        }
        return customer;
    }

    @Override
    public Customer findCustomerByNationalId(String nationalId)  throws NoResultException {
        TypedQuery<Customer> query = this.em.createQuery(
                "From Customer where nationalId=:nationalId", Customer.class);
        query.setParameter("nationalId", nationalId);
        Customer customer = query.getSingleResult();
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Customer existingCustomer = this.em.find(Customer.class, customer.getId());
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("customer not found for update with id : " + customer.getId());
        }
        this.em.merge(customer);
        return customer;
    }

    @Override
    public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
        Customer existingCustomer = this.em.find(Customer.class, customer.getId());
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("customer not found for delete with id : " + customer.getId());
        }
        this.em.remove(customer);
        return customer;
    }
}
