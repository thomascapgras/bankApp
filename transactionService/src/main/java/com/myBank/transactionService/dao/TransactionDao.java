package com.myBank.transactionService.dao;

import com.myBank.transactionService.entities.Transaction;
import com.myBank.transactionService.exceptions.TransactionNotFound;

import java.util.List;

public interface TransactionDao {
    public Transaction createTransaction (Transaction transaction);
    public Transaction findTransactionById(int id) throws TransactionNotFound;
    public List<Transaction> findTransactionsByCustomerId(int customerId) throws TransactionNotFound;
    public List<Transaction> findTransactionsByEmmiterAccount(String fromAccount) throws TransactionNotFound;

}
