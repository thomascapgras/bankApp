package com.myBank.accountService.dao;

import com.myBank.accountService.entities.Account;
import com.myBank.accountService.exception.AccountNotFoundException;
import com.myBank.accountService.exception.NegativeBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.math.BigDecimal;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private EntityManager em;
    @Override
    public Account openAccount(Account account) {
        this.em.persist(account);
        return account;
    }

    @Override
    public Account findAccountByNumber(String accountNumber) throws NoResultException {
        TypedQuery<Account> query = this.em.createQuery("From Account where accountNumber=:accountNumber", Account.class);
        query.setParameter("accountNumber",accountNumber);
        Account account = query.getSingleResult();
        return account;
    }

    @Override
    public Account findAccountByCustomerId(int customerId) throws NoResultException {
        TypedQuery<Account> query = this.em.createQuery("From Account where customerId=:customerId", Account.class);
        query.setParameter("customerId",customerId);
        Account account = query.getSingleResult();
        return account;
    }

    @Override
    public Account findAccountById(int id) throws AccountNotFoundException {
        Account account = this.em.find(Account.class,id);
        if (account==null){
            throw new AccountNotFoundException("account not found  with id : " + id);
        }
        return account;
    }

    @Override
    public Account updateAccount(Account account) throws AccountNotFoundException {
        Account existingAccount = this.em.find(Account.class,account.getId());
        if (existingAccount==null){
            throw new AccountNotFoundException("account not found for update with id : " + account.getId());
        }
        this.em.merge(account);
        return account;
    }

    @Override
    public Account deleteAccount(Account account) throws AccountNotFoundException {
        Account existingAccount = this.em.find(Account.class,account.getId());
        if (existingAccount==null){
            throw new AccountNotFoundException("account not found for delete with id : " + account.getId());
        }
        this.em.remove(existingAccount);
        return account;
    }
}
