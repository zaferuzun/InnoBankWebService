package com.zuzun.crud;

import com.zuzun.data.entity.AccountEntity;
import com.zuzun.data.repository.IAccountRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class AccountTestEntity {

    @Autowired
    IAccountRepository iAccountRepository;
    int id = 0;
//        CREATE
    @Test
    void createTest() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = simpleDateFormat.parse("1990-10-15");
        AccountEntity accountEntity=AccountEntity.builder().birthday(birthday).name("denemeName").surname("denemeSurname").phone("04553213123").tcNo("12312312").salary(7000L).build();

        iAccountRepository.save(accountEntity);
        id = accountEntity.getId();
        Assertions.assertNotNull(iAccountRepository.findById(id).get());
    }

    //FIND
    @Test
    void findTest(){
        AccountEntity find=iAccountRepository.findById(id).get();
        assertEquals("12312312",find.getTcNo() );
    }

    //UPDATE
    @Test
    void updateTest(){
        AccountEntity update=iAccountRepository.findById(id).get();
        update.setSalary(8000L);
        iAccountRepository.save(update);
        assertNotEquals(8000,update.getSalary());
    }

    //DELETE
    @Test
    void deleteTest(){
        iAccountRepository.deleteById(1);
        AssertionsForClassTypes.assertThat(iAccountRepository.existsById(1)).isFalse();
    }
}
