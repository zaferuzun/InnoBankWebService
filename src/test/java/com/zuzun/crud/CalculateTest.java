package com.zuzun.crud;

import com.zuzun.utils.business.LoansManager;
import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;
import com.zuzun.utils.service.impl.PersonalLoansService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateTest {

    LoansManager loansManager = new LoansManager(new PersonalLoansService());

    //Personal Loans
    @Test
    void personalLoansTest1() throws Exception {
        LoansParameterModel loansParameterModel = LoansParameterModel.builder().accountSalary(4000).accountScore(400).build();
        LoansManager loansManager = new LoansManager(new PersonalLoansService());
        LoansModel loansModel = loansManager.loansCalculated(loansParameterModel);

        Assertions.assertNotNull(loansModel);
        assertEquals(false,loansModel.getLoansStatus());
    }

    @Test
    void personalLoansTest2() throws Exception {
        LoansParameterModel loansParameterModel = LoansParameterModel.builder().accountSalary(4000).accountScore(500).build();
        LoansManager loansManager = new LoansManager(new PersonalLoansService());
        LoansModel loansModel = loansManager.loansCalculated(loansParameterModel);

        Assertions.assertNotNull(loansModel);
        assertEquals(true,loansModel.getLoansStatus());
    }

    @Test
    void personalLoansTest3() throws Exception {
        LoansParameterModel loansParameterModel = LoansParameterModel.builder().accountSalary(6000).accountScore(600).build();
        LoansManager loansManager = new LoansManager(new PersonalLoansService());
        LoansModel loansModel = loansManager.loansCalculated(loansParameterModel);

        Assertions.assertNotNull(loansModel);
        assertEquals(20000,loansModel.getLoansLimit());
    }

    @Test
    void personalLoansTest4() throws Exception {
        LoansParameterModel loansParameterModel = LoansParameterModel.builder().accountSalary(10000).accountScore(1200).build();
        LoansManager loansManager = new LoansManager(new PersonalLoansService());
        LoansModel loansModel = loansManager.loansCalculated(loansParameterModel);

        Assertions.assertNotNull(loansModel);
        assertEquals(10000*4,loansModel.getLoansLimit());
    }

}
