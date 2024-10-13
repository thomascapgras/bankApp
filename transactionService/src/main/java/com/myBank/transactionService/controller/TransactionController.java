package com.myBank.transactionService.controller;

import com.myBank.transactionService.dto.TransactionDto;
import com.myBank.transactionService.exceptions.TransactionNotFound;
import com.myBank.transactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/createTransaction")
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transactionDto){
        transactionDto = this.transactionService.createTransaction(transactionDto);
        return new ResponseEntity<TransactionDto>(transactionDto, HttpStatus.OK);
    }

    @GetMapping("/getTransactionById/{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> getTransactionById(@PathVariable int id){
        try{
            TransactionDto transactionDto = this.transactionService.findTransactionById(id);
            return new ResponseEntity<TransactionDto>(transactionDto,HttpStatus.OK);
        }catch (TransactionNotFound e){
            return new ResponseEntity<String>("transaction not found with id : " + id,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getTransactionsByCustomerId/{customerId}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> getTransactionsByCustomerId(@PathVariable int customerId){
        try{
            List<TransactionDto> transactionDtos = this.transactionService.findTransactionsByCustomerId(customerId);
            return new ResponseEntity<  List<TransactionDto>>(transactionDtos,HttpStatus.OK);
        }catch (TransactionNotFound e){
            return new ResponseEntity<String>("transaction not found with customerid : " + customerId,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getTransactionsByEmmiterAccount/{fromAccount}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<?> getTransactionsByCustomerId(@PathVariable String fromAccount){
        try{
            List<TransactionDto> transactionDtos = this.transactionService.findTransactionsByEmmiterAccount(fromAccount);
            return new ResponseEntity<  List<TransactionDto>>(transactionDtos,HttpStatus.OK);
        }catch (TransactionNotFound e){
            return new ResponseEntity<String>("transaction not found with account : " + fromAccount,HttpStatus.NOT_FOUND);
        }
    }

}
