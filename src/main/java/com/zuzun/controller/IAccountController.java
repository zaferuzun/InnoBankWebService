package com.zuzun.controller;


import com.zuzun.business.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface IAccountController {
    //Aylık gelir bilgisi

    @GetMapping("/{id}")
    ResponseEntity<AccountDto> getAccountById(@PathVariable int id)
            throws Exception;

    @PostMapping("/save")
    ResponseEntity<AccountDto> saveAccount(AccountDto accountDto)throws Exception;

    @PutMapping("/update/{id}")
    ResponseEntity<AccountDto> updateAccount(AccountDto accountDto, @PathVariable int id)throws Exception;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<AccountDto> deleteAccount (@PathVariable int id)throws Exception;


}
