package com.dovahkir.foodapp.security;

import com.dovahkir.foodapp.accountrole.account.Account;
import com.dovahkir.foodapp.accountrole.account.AccountService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if(account == null){
            throw new UsernameNotFoundException("User" + username + " not found");
        }
        if(account.getRole() == null || account.getRole().isEmpty()){
            throw new RuntimeException("User has no roles");
        }

        Collection<GrantedAuthority> authorities = account
                .getRole()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role
                                                        .getName()))
                                                        .collect(toList());
        return new User(account.getUsername()
                , account.getPassword()
                , account.isEnabled()
                , !account.isExpired()
                , !account.isCredentialsExpired()
                , !account.isLocked()
                , authorities);
    }
}
