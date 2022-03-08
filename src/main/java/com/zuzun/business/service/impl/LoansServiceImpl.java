package com.zuzun.business.service.impl;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.dto.LoansDto;
import com.zuzun.business.service.IAccountService;
import com.zuzun.business.service.ILoansService;
import com.zuzun.constant.ELoansType;
import com.zuzun.controller.ILoansController;
import com.zuzun.data.entity.AccountEntity;
import com.zuzun.data.entity.LoansEntity;
import com.zuzun.data.repository.IAccountRepository;
import com.zuzun.data.repository.ILoansRepository;
import com.zuzun.utils.business.LoansManager;
import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;
import com.zuzun.utils.service.impl.CarLoansService;
import com.zuzun.utils.service.impl.PersonalLoansService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private final @NonNull ILoansRepository iLoansRepository;
    private final @NonNull ModelMapper modelMapper;
//    private final @NonNull LoansManager loansManager;

    private LoansManager loansManager;

    @Override
    public ResponseEntity<LoansDto> getLoansById(int id) throws Exception {

        LoansEntity loansEntity = iLoansRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));
        return ResponseEntity.ok(EntityToDto(loansEntity));
    }

    public ResponseEntity<LoansDto> saveLoans(LoansDto loansDto) throws Exception {
        LoansEntity loansEntity = DtoToEntity(loansDto);

//        Arrays.stream(ELoansType.values())
//                .filter(e -> e.equals(loansDto.getType()))
//                .reduce((t1, t2) -> t1)
//                .orElseThrow(() -> {throw new IllegalStateException(String.format("Unsupported type %s.", loansDto.getType()));});

        LoansModel loansModel = loansCalculated(loansDto.getType(),loansDto.getLoansParameterModel());
        loansEntity.setAmount((long) loansModel.getLoansLimit());
        loansEntity.setApproval(loansModel.getLoansStatus());
        loansEntity.setMortgage(loansDto.getLoansParameterModel().getMortgage());

        iLoansRepository.save(loansEntity);

        return ResponseEntity.ok(EntityToDto(loansEntity));
    }

    @Override
    public ResponseEntity<LoansDto> updateLoans(LoansDto loansDto, int id) throws Exception {
        LoansEntity loansEntity = DtoToEntity(loansDto);//ModelMapper

        LoansEntity loans = iLoansRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not exist with id :" + id));

        loans.setApproval( loansEntity.getApproval());

        LoansEntity updatedLoans = iLoansRepository.save(loans);
        LoansDto loansDto1 = EntityToDto(updatedLoans);
        return ResponseEntity.ok(loansDto1);
    }

    @Override
    public ResponseEntity<LoansDto> deleteLoans(int id) {
        iLoansRepository.deleteById(id);
        return null;
    }

    //Model Mapper Entity ==> Dto
    @Override
    public LoansDto EntityToDto(LoansEntity loansEntity) {
        LoansDto loansDto = modelMapper.map(loansEntity, LoansDto.class);
        if(loansEntity.getMortgage()!=null)
        {
            LoansParameterModel loansParameterModel = LoansParameterModel.builder().mortgage(loansEntity.getMortgage()).build();
            loansDto.setLoansParameterModel(loansParameterModel);
        }
        return loansDto;
    }

    //Model Mapper Dto  ==> Entity
    @Override
    public LoansEntity DtoToEntity(LoansDto loansDto) {
        LoansEntity loansEntity = modelMapper.map(loansDto, LoansEntity.class);
        return loansEntity;
    }

    //loans calculation
    @Override
    public LoansModel loansCalculated(String loansType,LoansParameterModel loansParameterModel) throws Exception {

        if (loansType.equals(ELoansType.Personal.name()))
        {
            loansManager = new LoansManager(new PersonalLoansService());
            return loansManager.loansCalculated(loansParameterModel);
        }
        else if (loansType.equals(ELoansType.Car.name()))
        {
            loansManager = new LoansManager(new CarLoansService());
            return loansManager.loansCalculated(loansParameterModel);
        }
        else
            throw new Exception();

    }

    @Override
    public ResponseEntity<LoansDto> getLoansByAccountId(int id) {
        LoansEntity loansEntity = iLoansRepository.getLoansEntityByAccountId(id);
        return ResponseEntity.ok(EntityToDto(loansEntity));
    }

}