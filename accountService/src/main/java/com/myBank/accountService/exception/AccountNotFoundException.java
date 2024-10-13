package com.myBank.accountService.exception;

public class AccountNotFoundException extends  Exception{
    public AccountNotFoundException(String message) {
        super(message);
    }
}
