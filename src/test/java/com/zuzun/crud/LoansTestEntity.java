package com.zuzun.crud;

import com.zuzun.data.entity.AccountEntity;
import com.zuzun.data.entity.LoansEntity;
import com.zuzun.data.repository.IAccountRepository;
import com.zuzun.data.repository.ILoansRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class LoansTestEntity {

    @Autowired
    ILoansRepository iLoansRepository;
    int id=1;
//        CREATE
    @Test
    void createTest() throws ParseException {
        LoansEntity loansEntity = LoansEntity.builder().accountId(7).amount(100000L).approval(true).type("Personal").build();
        iLoansRepository.save(loansEntity);
        id=loansEntity.getId();
        Assertions.assertNotNull(iLoansRepository.findById(id).get());
    }

    //FIND
    @Test
    void findTest(){
        LoansEntity find=iLoansRepository.findById(id).get();
        assertEquals("Personal",find.getType() );
    }

    //UPDATE
    @Test
    void updateTest(){
        LoansEntity update=iLoansRepository.findById(id).get();
        update.setApproval(false);
        iLoansRepository.save(update);
        assertNotEquals(false,update.getApproval());
    }

    //DELETE
    @Test
    void deleteTest(){
        iLoansRepository.deleteById(1);
        AssertionsForClassTypes.assertThat(iLoansRepository.existsById(1)).isFalse();
    }
}
