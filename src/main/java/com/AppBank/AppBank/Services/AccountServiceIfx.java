package com.AppBank.AppBank.Services;

import com.AppBank.AppBank.Repositories.AccountRepository;
import com.AppBank.AppBank.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountServiceIfx {

    Account saveAccount(Account account) throws Exception;

    List<Account> findAll();

    Account findAccountById(Long id) throws Exception;

    Account updateAccount(Long id, Account account) throws Exception;

    void deleteAccountById(Long id);

}
