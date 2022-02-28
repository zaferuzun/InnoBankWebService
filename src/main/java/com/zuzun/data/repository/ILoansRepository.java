package com.zuzun.data.repository;

import com.zuzun.data.entity.AccountEntity;
import com.zuzun.data.entity.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoansRepository extends JpaRepository<LoansEntity,Integer> {

    LoansEntity getLoansEntityByAccountId(int accountId);
}
