package com.zuzun.data.repository;

import com.zuzun.data.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity,Integer> {

    AccountEntity getAccountEntityByTcNo(String tcNo);

}
