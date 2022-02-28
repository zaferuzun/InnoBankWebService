package com.zuzun.controller.imp;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.dto.LoansDto;
import com.zuzun.business.service.IAccountService;
import com.zuzun.business.service.ILoansService;
import com.zuzun.controller.IAccountController;
import com.zuzun.controller.ILoansController;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoansControllerImpl implements ILoansController {

    private final @NonNull ILoansService iLoansService;

    // http://localhost:8080/api/loans/{id}
    @Override
    public ResponseEntity<LoansDto> getLoansById(int id) throws Exception {
        return iLoansService.getLoansById(id);
    }

    // http://localhost:8080/api/loans/save
    @Override
    public ResponseEntity<LoansDto> saveLoans(@RequestBody LoansDto loansDto) throws Exception {
        return iLoansService.saveLoans(loansDto);
    }
    // http://localhost:8080/api/loans/update/{id}
    @Override
    public ResponseEntity<LoansDto> updateLoans(@RequestBody LoansDto loansDto, int id) throws Exception {
        return iLoansService.updateLoans(loansDto,id);
    }
    // http://localhost:8080/api/loans/delete/{id}

    @Override
    public ResponseEntity<LoansDto> deleteLoans(int id) throws Exception {
        return iLoansService.deleteLoans(id);
    }
}
