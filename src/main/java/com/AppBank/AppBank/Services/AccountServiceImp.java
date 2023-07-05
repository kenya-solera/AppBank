package com.AppBank.AppBank.Services;

import com.AppBank.AppBank.Repositories.AccountRepository;
import com.AppBank.AppBank.entities.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImp implements AccountServiceIfx{
    //Dependency injection through constructor as recommended by Spring
    AccountRepository accountRepo;
    public AccountServiceImp(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account saveAccount(Account account) {
        accountRepo.save(account);
        return account;
    }

    @Override
    public Account findAccountById(Long id) throws Exception {
        Optional<Account> accountOp = accountRepo.findById(id);
        if(accountOp.isEmpty()){
            throw new Exception("Account not found");
        }
        return accountOp.get();
    }

    @Override
    public Account updateAccount(Long id) {
        return null;
    }

    @Override
    public void deleteAccountById(Long id) {

    }
}
