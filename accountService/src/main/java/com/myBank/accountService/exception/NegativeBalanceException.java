package com.myBank.accountService.exception;

public class NegativeBalanceException  extends  Exception{
    public NegativeBalanceException(String message) {
        super(message);
    }
}
