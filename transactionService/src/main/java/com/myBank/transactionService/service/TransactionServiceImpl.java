package com.myBank.transactionService.service;

import com.myBank.transactionService.dao.TransactionDao;
import com.myBank.transactionService.dto.TransactionDto;
import com.myBank.transactionService.entities.Transaction;
import com.myBank.transactionService.entities.TransactionUpdate;
import com.myBank.transactionService.entities.enumerations.TransactionStatus;
import com.myBank.transactionService.exceptions.TransactionNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionUpdatePublisher transactionUpdatePublisher;
    @Autowired
    private TransactionDao transactionDao;
    @Override
    @Transactional
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction(transactionDto);
        transaction.setStatus(TransactionStatus.PENDING);
        this.transactionDao.createTransaction(transaction);
        transactionDto = new TransactionDto(transaction);
        TransactionUpdate transactionUpdate = new TransactionUpdate("TRANSACTION_CREATED",transactionDto);

        transactionUpdatePublisher.publishTransactionUpdate(transactionUpdate);
        return transactionDto;
    }

    @Override
    public TransactionDto findTransactionById(int id) throws TransactionNotFound {
        Transaction transaction = this.transactionDao.findTransactionById(id);
        TransactionDto transactionDto = new TransactionDto(transaction);
        return transactionDto;
    }

    @Override
    public List<TransactionDto> findTransactionsByCustomerId(int customerId) throws TransactionNotFound {
        List<Transaction> transactions = this.transactionDao.findTransactionsByCustomerId(customerId);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Transaction transaction : transactions){
            transactionDtos.add(new TransactionDto(transaction));
        }
        return transactionDtos;
    }

    @Override
    public List<TransactionDto> findTransactionsByEmmiterAccount(String fromAccount) throws TransactionNotFound {
        List<Transaction> transactions = this.transactionDao.findTransactionsByEmmiterAccount(fromAccount);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Transaction transaction : transactions){
            transactionDtos.add(new TransactionDto(transaction));
        }
        return transactionDtos;
    }
}
