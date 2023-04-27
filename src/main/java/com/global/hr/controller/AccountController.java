package com.global.hr.controller;

import com.global.hr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping(path = "/role/{roleName}")
    public ResponseEntity<?> addRoleForAllUsers(@PathVariable("roleName")String roleName){
        accountService.addRoleForAllAccounts(roleName);
        return ResponseEntity.ok(null);
    }
}
