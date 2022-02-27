package com.zuzun.controller.imp;

import com.zuzun.controller.IAccountController;
import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.service.IAccountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountControllerImpl implements IAccountController {
    private final @NonNull IAccountService accountService;

    // http://localhost:8080/api/account/{id}
    @Override
    public ResponseEntity<AccountDto> getAccountById(@PathVariable int id)throws Exception{
        return accountService.getAccountById(id);
    }

    // http://localhost:8080/api/account/save
    @Override
    public ResponseEntity<AccountDto> saveAccount(@RequestBody  AccountDto accountDto) throws Exception {
        return accountService.saveAccount(accountDto);
    }

    // http://localhost:8080/api/account/update/{id}
    @Override
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto,int id) throws Exception {
        return accountService.updateAccount(accountDto,id);
    }

    // http://localhost:8080/api/account/delete/{id}
    @Override
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable int id) throws Exception {
        return accountService.deleteAccount(id);
    }

}
