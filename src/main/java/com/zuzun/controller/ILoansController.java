package com.zuzun.controller;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ILoansController {

    @GetMapping("/{id}")
    ResponseEntity<LoansDto> getLoansById(@PathVariable int id)
            throws Exception;

    @PostMapping("/save")
    ResponseEntity<LoansDto> saveLoans(LoansDto loansDto)throws Exception;

    @PutMapping("/update/{id}")
    ResponseEntity<LoansDto> updateLoans(LoansDto loansDto, @PathVariable int id)throws Exception;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<LoansDto> deleteLoans (@PathVariable int id)throws Exception;

    @PostMapping("")
    ResponseEntity<LoansDto> getLoansByAccountId(@PathVariable int id)
            throws Exception;
}
