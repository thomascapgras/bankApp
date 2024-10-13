package com.myBank.accountService.dao;

import com.myBank.accountService.entities.Account;
import com.myBank.accountService.exception.AccountNotFoundException;
import com.myBank.accountService.exception.NegativeBalanceException;

import javax.persistence.NoResultException;

public interface AccountDao {
    public Account openAccount(Account account);
    public Account findAccountByNumber (String accountNumber) throws NoResultException;
    public Account findAccountByCustomerId(int customerId) throws NoResultException;
    public Account findAccountById(int id ) throws AccountNotFoundException;
    public Account updateAccount(Account account) throws AccountNotFoundException;
    public Account deleteAccount(Account account) throws AccountNotFoundException;

}
