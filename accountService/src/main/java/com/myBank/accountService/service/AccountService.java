package com.myBank.accountService.service;

import com.myBank.accountService.dto.AccountDto;
import com.myBank.accountService.dto.TransactionDto;
import com.myBank.accountService.entities.Account;
import com.myBank.accountService.exception.AccountNotFoundException;

import javax.persistence.NoResultException;

public interface AccountService{
    public AccountDto openAccount(AccountDto accountDto);
    public AccountDto findAccountByNumber (String accountNumber) throws NoResultException;
    public AccountDto findAccountByCustomerId(int customerId) throws NoResultException;
    public AccountDto findAccountById(int id ) throws AccountNotFoundException;
    public AccountDto deleteAccount(AccountDto accountDto) throws AccountNotFoundException;

    public void balanceAccount(TransactionDto transactionDto);
}



