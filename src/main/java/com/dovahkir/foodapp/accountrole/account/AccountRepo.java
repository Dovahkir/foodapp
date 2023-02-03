package com.dovahkir.foodapp.accountrole.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
}
