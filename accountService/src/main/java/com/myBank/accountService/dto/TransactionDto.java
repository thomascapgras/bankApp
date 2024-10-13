package com.myBank.accountService.dto;


import com.myBank.accountService.entities.enumerations.TransactionStatus;
import com.myBank.accountService.entities.enumerations.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
;
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
    @NotNull(message = "transaction-status is required")
    private TransactionStatus status;
    private int customerId;

    public TransactionDto (){

    }


}
