package com.dovahkir.foodapp.accountrole.account;

import com.dovahkir.foodapp.accountrole.role.Role;
import com.dovahkir.foodapp.accountrole.role.RoleRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountServiceImpl implements AccountService{
    private AccountRepo accountRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;


    public AccountServiceImpl(AccountRepo accountRepo, RoleRepo roleRepo, PasswordEncoder encoder, PasswordEncoder passwordEncoder) {
        this.accountRepo = accountRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account createAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Role role = roleRepo.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRole(roles);
        return accountRepo.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepo.findByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        return (List<Account>) accountRepo.findAll();
    }
}
