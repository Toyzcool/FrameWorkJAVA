package com.service;

import com.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    public List<Account> findAll() {
        System.out.println("业务层：获取所有账户...");
        return null;
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：添加账户...");
    }
}
