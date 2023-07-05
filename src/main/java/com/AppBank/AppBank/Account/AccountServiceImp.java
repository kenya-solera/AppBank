package com.AppBank.AppBank.Account;

import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountServiceIfx {
    //Dependency injection through constructor as recommended by Spring
    AccountRepository accountRepo;
    public AccountServiceImp(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account saveAccount(Account account) throws Exception {
        if(account == null) {
            throw new InvalidParameterException("account cannot be empty");
        }
        accountRepo.save(account);
        return account;
    }

    @Override
    public List<Account> findAll(){
        return accountRepo.findAll();
    }

    @Override
    public Account findAccountById(Long id) throws Exception {
        Optional<Account> accountOp = accountRepo.findById(id);
        if(accountOp.isEmpty()){
            throw new AccountNotFoundException("Account not found");
        }
        return accountOp.get();
    }

    @Override
    public Account updateAccount(Long id, Account account) throws Exception {
        Optional<Account> updatedAccOp = accountRepo.findById(id);

        if(updatedAccOp.isEmpty()){
            throw new IllegalArgumentException("Account not found");
        }
        Account updatedAccount = updatedAccOp.get();

        updatedAccount.setName(account.getName());
        updatedAccount.setBalance(account.getBalance());
        updatedAccount.setTransactions(account.getTransactions());
        //TODO: make sure only admins can change owners, not the clients
        updatedAccount.setOwner(account.getOwner());

        return updatedAccount;
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepo.deleteById(id);
    }
}
