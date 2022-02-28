package com.zuzun.business.service;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.data.entity.AccountEntity;
import org.springframework.http.ResponseEntity;

public interface IAccountService {

    ResponseEntity<AccountDto> getAccountById(int id) throws Exception;

    ResponseEntity<AccountDto> saveAccount(AccountDto accountDto);

    ResponseEntity<AccountDto> updateAccount(AccountDto accountDto,int id) throws Exception;

    ResponseEntity<AccountDto> deleteAccount(int id);

    ResponseEntity<AccountDto> getAccountByTcNo(String tcNo);

    AccountDto EntityToDto(AccountEntity accountEntity);
    AccountEntity DtoToEntity(AccountDto accountDto);

}