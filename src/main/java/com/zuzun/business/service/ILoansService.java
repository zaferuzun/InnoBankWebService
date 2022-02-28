package com.zuzun.business.service;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.dto.LoansDto;
import com.zuzun.data.entity.AccountEntity;
import com.zuzun.data.entity.LoansEntity;
import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;
import org.springframework.http.ResponseEntity;

public interface ILoansService {

    ResponseEntity<LoansDto> getLoansById(int id) throws Exception;

    ResponseEntity<LoansDto> saveLoans(LoansDto loansDto) throws Exception;

    ResponseEntity<LoansDto> updateLoans(LoansDto loansDto,int id) throws Exception;

    ResponseEntity<LoansDto> deleteLoans(int id);

    LoansDto EntityToDto(LoansEntity loansEntity);
    LoansEntity DtoToEntity(LoansDto loansDto);
    LoansModel loansCalculated(String loansType, LoansParameterModel loansParameterModel) throws Exception;

    ResponseEntity<LoansDto> getLoansByAccountId(int id);

}