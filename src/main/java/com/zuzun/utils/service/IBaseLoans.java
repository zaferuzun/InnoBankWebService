package com.zuzun.utils.service;


import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;

public interface IBaseLoans {

    //calculated loans
    LoansModel getLoansCalculation(LoansParameterModel loansParameterModel) throws Exception;

}
