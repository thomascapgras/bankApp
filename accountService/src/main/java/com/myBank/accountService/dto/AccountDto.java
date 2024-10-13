package com.myBank.accountService.dto;

import com.myBank.accountService.entities.Account;
import com.myBank.accountService.entities.enumerations.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @ToString
public class AccountDto {
    private int id;
    @NotNull(message = "accountNumber is mandatory")
    private String accountNumber;
    @NotNull(message = "accountType is mandatory")
    private AccountType accountType;
    @NotNull(message = "balance is mandatory")
    private BigDecimal balance;
    @NotNull(message = "currency is mandatory")
    private String currency;
    @NotNull(message = "creationDate is mandatory")
    private LocalDateTime creationDate;
    @NotNull(message = "customerId is mandatory")
    private int customerId;
    public AccountDto (){

    }

    public AccountDto (Account account){
        this.id = account.getId();
        this.accountNumber = account.getAccountNumber();
        this.accountType = account.getAccountType();
        this.balance = account.getBalance();
        this.currency = account.getCurrency();
        this.creationDate = account.getCreationDate();
        this.customerId = account.getCustomerId();
    }

}
