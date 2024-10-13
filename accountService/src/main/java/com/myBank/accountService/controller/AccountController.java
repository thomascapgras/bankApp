package com.myBank.accountService.controller;

import com.myBank.accountService.dto.AccountDto;
import com.myBank.accountService.exception.AccountNotFoundException;
import com.myBank.accountService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.persistence.NoResultException;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/openAccount")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?>  openAccount(@RequestBody AccountDto accountDto){
        accountDto = this.accountService.openAccount(accountDto);
        return new ResponseEntity<AccountDto>(accountDto, HttpStatus.OK);
    }
    @GetMapping("/getAccountByNumber/{accountNumber}")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?> getAccountByNumber(@PathVariable String accountNumber){
        try{
            AccountDto accountDto = this.accountService.findAccountByNumber(accountNumber);
            return new ResponseEntity<AccountDto>(accountDto,HttpStatus.OK);
        }catch (NoResultException e){
            return new ResponseEntity<String>("account not found with account number : "+ accountNumber,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAccountByCustomerId/{customerId}")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?> getAccountByNumber(@PathVariable int  customerId){
        try{
            AccountDto accountDto = this.accountService.findAccountByCustomerId(customerId);
            return new ResponseEntity<AccountDto>(accountDto,HttpStatus.OK);
        }catch (NoResultException e){
            return new ResponseEntity<String>("account not found with customer id  : "+ customerId,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAccount")
    @RolesAllowed({"ADMIN","USER"})
    public ResponseEntity<?>  deleteAccount(@RequestBody AccountDto accountDto){
        try {
            accountDto = this.accountService.deleteAccount(accountDto);
            return new ResponseEntity<AccountDto>(accountDto,HttpStatus.OK);
        } catch (AccountNotFoundException e) {
            return new ResponseEntity<String>("account not found for delete with customer id  : "+ accountDto.getId(),HttpStatus.NOT_FOUND);
        }
    }

}
