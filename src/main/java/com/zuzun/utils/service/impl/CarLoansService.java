package com.zuzun.utils.service.impl;


import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;
import com.zuzun.utils.service.ICarLoans;

public class CarLoansService implements ICarLoans {
    LoansModel loansModel =new LoansModel();

    @Override
    public LoansModel getLoansCalculation(LoansParameterModel loansParameterModel) throws Exception {
        int accountScore=loansParameterModel.getAccountScore();
        double accountSalary= loansParameterModel.getAccountSalary();
        double mortgage = loansParameterModel.getMortgage();

        if(accountScore<500)
        {
            loansModel.setLoansLimit(0);
            loansModel.setLoansStatus(false);
        }
        else if ( (500<=accountScore && accountScore<=1000)  && accountSalary<5000 && mortgage<100000){
            loansModel.setLoansStatus(true);
            loansModel.setLoansLimit(mortgageCalculated(mortgage,50));
        }
        else if ((500<=accountScore && accountScore<=1000)  && accountSalary>5000 && mortgage<150000 ){
            loansModel.setLoansStatus(true);
            loansModel.setLoansLimit(mortgageCalculated(mortgage,40));
        }
        else if (accountScore>=1000)
        {
            loansModel.setLoansStatus(true);
            loansModel.setLoansLimit(mortgageCalculated(mortgage,30));

        }
        else
        {
            loansModel.setLoansLimit(0);
            loansModel.setLoansStatus(false);
            throw new Exception();
        }
        return loansModel;

    }

    @Override
    public double mortgageCalculated(double mortgageAmount,int percentile) {
        return mortgageAmount-(mortgageAmount*percentile/100);
    }
}
