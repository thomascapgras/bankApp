package com.myBank.transactionService.dto;

import com.myBank.transactionService.entities.Transaction;
import com.myBank.transactionService.entities.enumerations.TransactionStatus;
import com.myBank.transactionService.entities.enumerations.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @ToString
public class TransactionDto {


    private int id;
    @NotNull(message = "transactionType is required")
    private TransactionType transactionType;
    @NotNull(message = "amount is required")
    private BigDecimal amount;
    @NotNull(message = "currency is required")
    private String currency;
    @NotNull(message = "transactionDate is required")
    private LocalDateTime transactionDate;
    private String fromAccount;
    private String toAccount;
    private String description;
    private TransactionStatus status;
    private int customerId;

    public TransactionDto (){

    }

    public TransactionDto(Transaction transaction) {
        this.id = transaction.getId();
        this.transactionType = transaction.getTransactionType();
        this.amount = transaction.getAmount();
        this.currency = transaction.getCurrency();
        this.transactionDate = transaction.getTransactionDate();
        this.fromAccount = transaction.getFromAccount();
        this.toAccount = transaction.getToAccount();
        this.description = transaction.getDescription();
        this.status = transaction.getStatus();
        this.customerId = transaction.getCustomerId();
    }
}
