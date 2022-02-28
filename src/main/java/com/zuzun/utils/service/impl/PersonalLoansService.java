package com.zuzun.utils.service.impl;

import com.zuzun.utils.pojo.LoansModel;
import com.zuzun.utils.pojo.LoansParameterModel;
import com.zuzun.utils.service.IPersonalLoans;

public class PersonalLoansService implements IPersonalLoans {
//    boolean loansStatus =false;

    LoansModel loansModel =new LoansModel();
    double creditMultiplier=4;

//    @Override
//    public <LoansModel> LoansModel getLoansCalculation(T model) throws Exception {
//
//        if(model<500)
//        {
//            loansModel.setLoansLimit(0);
//            loansModel.setLoansStatus(false);
//        }
//        else if ( (500<=accountScore && accountScore<=1000)  && accountSalary<5000){
//            loansModel.setLoansStatus(true);
//            loansModel.setLoansLimit(10000);
//        }
//        else if ((500<=accountScore && accountScore<=1000)  && accountSalary>5000){
//            loansModel.setLoansStatus(true);
//            loansModel.setLoansLimit(20000);
//        }
//        else if (accountScore>=1000)
//        {
//            loansModel.setLoansLimit(accountSalary*this.creditMultiplier);
//            loansModel.setLoansStatus(true);
//        }
//        else
//        {
//            loansModel.setLoansLimit(0);
//            loansModel.setLoansStatus(false);
//            throw new Exception();
//        }
//        return (LoansModel) loansModel;
//    }

    @Override
    public LoansModel getLoansCalculation(LoansParameterModel loansParameterModel) throws Exception {
//        Class<PersonalModel> personalModel = ( ((Class<PersonalModel>) tModel));
//        PersonalModel personalModel1 = (PersonalModel) tModel.cast(PersonalModel.class);

        int accountScore=loansParameterModel.getAccountScore();
        double accountSalary= loansParameterModel.getAccountSalary();

        if(accountScore<500)
        {
            loansModel.setLoansLimit(0);
            loansModel.setLoansStatus(false);
        }
        else if ( (500<=accountScore && accountScore<=1000)  && accountSalary<5000){
            loansModel.setLoansStatus(true);
            loansModel.setLoansLimit(10000);
        }
        else if ((500<=accountScore && accountScore<=1000)  && accountSalary>5000){
            loansModel.setLoansStatus(true);
            loansModel.setLoansLimit(20000);
        }
        else if (accountScore>=1000)
        {
            loansModel.setLoansLimit(accountSalary*this.creditMultiplier);
            loansModel.setLoansStatus(true);
        }
        else
        {
            loansModel.setLoansLimit(0);
            loansModel.setLoansStatus(false);
            throw new Exception();
        }
        return loansModel;
    }
}
