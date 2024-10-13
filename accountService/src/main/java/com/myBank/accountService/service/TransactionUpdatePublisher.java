package com.myBank.accountService.service;

import com.myBank.accountService.entities.TransactionUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;


@Service
@EnableBinding(Source.class)
public class TransactionUpdatePublisher {
    private static final Logger logger = LoggerFactory.getLogger(TransactionUpdatePublisher.class);
    private final Source source;
    public TransactionUpdatePublisher(Source source) {
        this.source = source;
    }
    public void publishTransactionUpdate(TransactionUpdate transactionUpdate) {
        logger.debug("sending transaction-update :  "  + transactionUpdate);
        source.output().send(MessageBuilder.withPayload(transactionUpdate).build());
    }
}
