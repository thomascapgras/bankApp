package com.myBank.transactionService.service;

import com.myBank.transactionService.dto.TransactionDto;
import com.myBank.transactionService.entities.Transaction;
import com.myBank.transactionService.exceptions.TransactionNotFound;

import java.util.List;

public interface TransactionService {
    public TransactionDto createTransaction (TransactionDto transactionDto);
    public TransactionDto findTransactionById(int id) throws TransactionNotFound;
    public List<TransactionDto> findTransactionsByCustomerId(int customerId) throws TransactionNotFound;
    public List<TransactionDto> findTransactionsByEmmiterAccount(String fromAccount) throws TransactionNotFound;
}
