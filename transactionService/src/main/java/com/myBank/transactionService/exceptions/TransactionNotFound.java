package com.myBank.transactionService.exceptions;

public class TransactionNotFound extends Exception{
    public TransactionNotFound(String message) {
        super(message);
    }
}
