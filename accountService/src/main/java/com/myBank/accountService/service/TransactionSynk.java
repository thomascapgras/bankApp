package com.myBank.accountService.service;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
public interface TransactionSynk {
    String TRANSACTION_INPUT = "transactionInput";
    @Input(TRANSACTION_INPUT)
    SubscribableChannel transactionInput();
}