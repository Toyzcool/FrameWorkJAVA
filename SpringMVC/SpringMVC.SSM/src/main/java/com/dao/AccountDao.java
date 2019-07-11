package com.dao;

import com.domain.Account;

import java.util.List;

public interface AccountDao {
//    获取账户列表
    public List<Account> findAll();
//    保存账户
    public void saveAccount(Account account);
}
