package com.myBank.accountService.entities;

import com.myBank.accountService.dto.AccountDto;
import com.myBank.accountService.entities.enumerations.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name="accounts")
@Getter @Setter @ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="account_number",unique = true, nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name ="account_type" , nullable = false)
    private AccountType accountType;

    @Column(name ="balance" ,nullable = false)
    private BigDecimal balance;

    @Column(name ="currency" ,nullable = false)
    private String currency;

    @Column(name ="creationDate" ,nullable = false)
    private LocalDateTime creationDate;

    @Column(name ="customerId",nullable = false)
    private int customerId;

    public Account() {
    }

    public Account(AccountDto accountDto) {
        this.id = accountDto.getId();
        this.accountNumber = accountDto.getAccountNumber();
        this.accountType = accountDto.getAccountType();
        this.balance = accountDto.getBalance();
        this.currency = accountDto.getCurrency();
        this.creationDate = accountDto.getCreationDate();
        this.customerId = accountDto.getCustomerId();
    }
}
