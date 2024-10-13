package com.myBank.transactionService.entities;

import com.myBank.transactionService.dto.TransactionDto;
import com.myBank.transactionService.entities.enumerations.TransactionStatus;
import com.myBank.transactionService.entities.enumerations.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter @Setter @ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name ="transaction_type",nullable = false)
    private TransactionType transactionType;

    @Column(name="amount",nullable = false)
    private BigDecimal amount;

    @Column(name="currency", nullable = false)
    private String currency;

    @Column(name="transaction_date",nullable = false)
    private LocalDateTime transactionDate;
    @Column(name="from_account")
    private String fromAccount;
    @Column(name="to_account")
    private String toAccount;
    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_status",nullable = false)
    private TransactionStatus status;
    @Column(name="customerId")
    private int customerId;

    public Transaction() {
    }

    public Transaction(TransactionDto transactionDto) {
        this.id = transactionDto.getId();
        this.transactionType = transactionDto.getTransactionType();
        this.amount = transactionDto.getAmount();
        this.currency = transactionDto.getCurrency();
        this.transactionDate = transactionDto.getTransactionDate();
        this.fromAccount = transactionDto.getFromAccount();
        this.toAccount = transactionDto.getToAccount();
        this.description = transactionDto.getDescription();
        this.status = transactionDto.getStatus();
        this.customerId = transactionDto.getCustomerId();
    }
}
