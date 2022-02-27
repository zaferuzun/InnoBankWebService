package com.zuzun.service;

import com.zuzun.dto.AccountDto;
import com.zuzun.entity.AccountEntity;
import org.springframework.http.ResponseEntity;

public interface IAccountService {

    ResponseEntity<AccountDto> getAccountById(int id) throws Exception;

    ResponseEntity<AccountDto> saveAccount(AccountDto accountDto);

    ResponseEntity<AccountDto> updateAccount(AccountDto accountDto,int id);

    ResponseEntity<AccountDto> deleteAccount(int id);

    AccountDto EntityToDto(AccountEntity accountEntity);
    AccountEntity DtoToEntity(AccountDto accountDto);

}
