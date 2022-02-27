package com.zuzun.controller;

import com.zuzun.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ICreditController {

    @GetMapping("/{id}")
    ResponseEntity<AccountDto> getCreditById(@PathVariable int id)
            throws Exception;

    @PostMapping("/save")
    ResponseEntity<AccountDto> saveCredit(AccountDto accountDto)throws Exception;

    @PutMapping("/update/{id}")
    ResponseEntity<AccountDto> updateCredit(AccountDto accountDto, @PathVariable int id)throws Exception;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<AccountDto> deleteCredit (@PathVariable int id)throws Exception;
}
