package com.myBank.accountService.service;

import com.myBank.accountService.dao.AccountDao;
import com.myBank.accountService.dto.AccountDto;
import com.myBank.accountService.dto.TransactionDto;
import com.myBank.accountService.entities.Account;
import com.myBank.accountService.entities.TransactionUpdate;
import com.myBank.accountService.entities.enumerations.TransactionStatus;
import com.myBank.accountService.exception.AccountNotFoundException;
import com.myBank.accountService.exception.NegativeBalanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService{
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private TransactionUpdatePublisher transactionUpdatePublisher;
    @Autowired
    private AccountDao accountDao;
    @Override
    @Transactional
    public AccountDto openAccount(AccountDto accountDto) {
        Account account = new Account(accountDto);
        this.accountDao.openAccount(account);
        accountDto = new AccountDto(account);
        return accountDto;
    }

    @Override
    public AccountDto findAccountByNumber(String accountNumber) throws NoResultException {
        Account account = this.accountDao.findAccountByNumber(accountNumber);
        AccountDto  accountDto= new AccountDto(account);
        return accountDto;
    }

    @Override
    public AccountDto findAccountByCustomerId(int customerId) throws NoResultException {
        Account account = this.accountDao.findAccountByCustomerId(customerId);
        AccountDto  accountDto= new AccountDto(account);
        return accountDto;
    }

    @Override
    public AccountDto findAccountById(int id) throws AccountNotFoundException {
        Account account = this.accountDao.findAccountById(id);
        AccountDto  accountDto= new AccountDto(account);
        return accountDto;
    }

    @Override
    @Transactional
    public AccountDto deleteAccount(AccountDto accountDto) throws AccountNotFoundException {
        Account account = new Account(accountDto);
        this.accountDao.deleteAccount(account);
        accountDto = new AccountDto(account);
        return accountDto;
    }

    @Override
    @Transactional
    public void balanceAccount(TransactionDto transactionDto) {

        BigDecimal amountPaid = transactionDto.getAmount();
        String fromAccountNumber = transactionDto.getFromAccount();
        String toAccountNumber = transactionDto.getToAccount();

        Account fromAccount = this.accountDao.findAccountByNumber(fromAccountNumber);
        Account toAccount = this.accountDao.findAccountByNumber(toAccountNumber);


        fromAccount.setBalance(fromAccount.getBalance().subtract(amountPaid));
        toAccount.setBalance(toAccount.getBalance().add(amountPaid));

        logger.debug("Updated fromAccount: {}", fromAccount);
        logger.debug("Updated toAccount: {}", toAccount);
        TransactionUpdate transactionUpdate = new TransactionUpdate();
        try {
            this.accountDao.updateAccount(fromAccount);
            this.accountDao.updateAccount(toAccount);

            transactionDto.setStatus(TransactionStatus.SUCCESS);
            transactionUpdate.setEventType("TRANSACTION SUCCESSFUL");
            transactionUpdate.setEventData(transactionDto);
            transactionUpdatePublisher.publishTransactionUpdate(transactionUpdate);
        } catch (AccountNotFoundException e) {
            transactionDto.setStatus(TransactionStatus.FAILED);
            logger.debug("Accounts not found for transaction id: " + transactionDto.getId());
            transactionUpdatePublisher.publishTransactionUpdate(transactionUpdate);
        } catch (Exception e) {
            logger.error("unexpected error: " + transactionDto.getId(), e);
            transactionDto.setStatus(TransactionStatus.FAILED);
            transactionUpdate.setEventType("TRANSACTION FAILED");
            transactionUpdate.setEventData(transactionDto);
            transactionUpdatePublisher.publishTransactionUpdate(transactionUpdate);
        }
    }
}
