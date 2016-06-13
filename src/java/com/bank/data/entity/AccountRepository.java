package com.bank.data.entity;

import com.bank.base.BaseRepository;

public class AccountRepository extends BaseRepository<Account> {

    public AccountRepository() {
        super(Account.class);
    }
}
