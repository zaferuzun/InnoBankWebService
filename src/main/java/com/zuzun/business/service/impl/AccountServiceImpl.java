package com.zuzun.business.service.impl;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.service.IAccountService;
import com.zuzun.data.entity.AccountEntity;
import com.zuzun.data.repository.IAccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final @NonNull IAccountRepository iAccountRepository;
    private final @NonNull ModelMapper modelMapper;


    @Override
    public ResponseEntity<AccountDto> getAccountById(int id) throws Exception {

        AccountEntity accountEntity = iAccountRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));
        return ResponseEntity.ok(EntityToDto(accountEntity));
    }

    public ResponseEntity<AccountDto> saveAccount(AccountDto accountDto) {
        AccountEntity accountEntity = DtoToEntity(accountDto);
        iAccountRepository.save(accountEntity);

        return ResponseEntity.ok(EntityToDto(accountEntity));
    }

    @Override
    public ResponseEntity<AccountDto> updateAccount(AccountDto accountDto, int id) throws Exception {
        AccountEntity accountEntity = DtoToEntity(accountDto);//ModelMapper

        AccountEntity account = iAccountRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        account.setBirthday( accountEntity.getBirthday());
        account.setSalary(accountEntity.getSalary());
        account.setPhone(accountEntity.getPhone());

        AccountEntity updatedAccount = iAccountRepository.save(account);
        AccountDto accountDto1 = EntityToDto(updatedAccount);//model
        return ResponseEntity.ok(accountDto1);
    }

    @Override
    public ResponseEntity<AccountDto> deleteAccount(int id) {
        iAccountRepository.deleteById(id);
        return null;
    }


    ////////////////////////////////////
    //Model Mapper Entity ==> Dto
    @Override
    public AccountDto EntityToDto(AccountEntity accountEntity) {
        AccountDto accountDto = modelMapper.map(accountEntity, AccountDto.class);
        return accountDto;
    }

    //Model Mapper Dto  ==> Entity
    @Override
    public AccountEntity DtoToEntity(AccountDto accountDto) {
        AccountEntity accountEntity = modelMapper.map(accountDto, AccountEntity.class);
        return accountEntity;
    }

}