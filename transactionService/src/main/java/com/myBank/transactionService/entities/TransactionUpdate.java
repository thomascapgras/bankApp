package com.myBank.transactionService.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TransactionUpdate {
    private String eventType;
    private Object eventData;

    public TransactionUpdate(){

    }

    public TransactionUpdate(String eventType, Object eventData){
        this.eventType = eventType;
        this.eventData=eventData;
    }

}
