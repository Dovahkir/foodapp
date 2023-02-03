package com.dovahkir.foodapp.accountrole.account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);

    Account findByUsername(String username);

    List<Account> getAccounts();
}
