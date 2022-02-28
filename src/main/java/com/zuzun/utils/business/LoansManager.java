package com.zuzun.utils.business;


import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;
import com.zuzun.utils.service.IBaseLoans;

public class LoansManager {

    IBaseLoans iBaseLoans;
    LoansModel loansModel;

    public LoansManager(IBaseLoans iBaseLoans){
        this.iBaseLoans=iBaseLoans;
    }

    public LoansModel loansCalculated(LoansParameterModel loansParameterModel) throws Exception {

        return iBaseLoans.getLoansCalculation(loansParameterModel);
    }

}
