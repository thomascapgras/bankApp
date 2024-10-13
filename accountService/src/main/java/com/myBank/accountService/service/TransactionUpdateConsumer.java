package com.myBank.accountService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myBank.accountService.dao.AccountDao;
import com.myBank.accountService.dto.TransactionDto;
import com.myBank.accountService.entities.TransactionUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@EnableBinding(TransactionSynk.class)
public class TransactionUpdateConsumer {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(TransactionSynk.class);

    @StreamListener(TransactionSynk.TRANSACTION_INPUT)
    public void handleTransactionUpdate(@Payload TransactionUpdate transactionUpdate) {
        logger.debug("Received transaction-update: {}", transactionUpdate);
        Map<String, Object> eventData = (Map<String, Object>) transactionUpdate.getEventData();
        TransactionDto transactionDto = objectMapper.convertValue(eventData, TransactionDto.class);
        this.accountService.balanceAccount(transactionDto);
    }


}
