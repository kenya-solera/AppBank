package com.AppBank.AppBank.Controllers;

import com.AppBank.AppBank.Services.AccountServiceIfx;
import com.AppBank.AppBank.Services.AccountServiceImp;
import com.AppBank.AppBank.entities.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountServiceImp accountSrvc;

    public AccountController(AccountServiceImp accountSrvc) {
        this.accountSrvc = accountSrvc;
    }

    @GetMapping("")
    public List<Account> seeAllAccounts(){
        return accountSrvc.findAll();
    }

    @GetMapping("/{id}")
    public Account seeAccount(@PathVariable Long id) throws Exception {
        return accountSrvc.findAccountById(id);
    }

    @PostMapping
    public Account newAccount(Account account) throws Exception {
        accountSrvc.saveAccount(account);
        return account;
    }

    @PutMapping("/{id}")
    public Account editAccount(@PathVariable Long id, Account account) throws Exception {
        accountSrvc.updateAccount(id, account);
        return account;
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountSrvc.deleteAccountById(id);
    }
}