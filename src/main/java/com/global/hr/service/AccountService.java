package com.global.hr.service;

import com.global.hr.entity.Account;
import com.global.hr.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public void wireAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findById(long id) {
        // could be handled better than that XD
        return accountRepository.findById(id).orElse(null);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> save(List<Account> accounts){
        return accountRepository.saveAll(accounts);
    }

    public Account update(Account account) {
        Optional<Account> optionalAccount = accountRepository.findById(account.getId());
        if (optionalAccount.isEmpty()) throw new RuntimeException("Account not found");

        Account dbAccount = optionalAccount.get();
        dbAccount.setUsername(account.getUsername());
        dbAccount.setPassword(account.getPassword());

        return accountRepository.save(dbAccount);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }
}
